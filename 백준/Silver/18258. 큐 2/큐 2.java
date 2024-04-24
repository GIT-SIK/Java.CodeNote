import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que = new ArrayDeque<>();
        br.lines().skip(1)
            .mapToInt(s -> {
              String[] str = s.split(" ");
              switch (str[0]) {
                  case "push":
                      que.add(Integer.parseInt(str[1]));
                      return -2;
                  case "front":
                      return que.isEmpty() ? -1 : que.element();
                  case "back":
                      return que.isEmpty() ? -1 : ((ArrayDeque<Integer>) que).peekLast();
                  case "size":
                      return que.size();
                  case "empty":
                      return que.isEmpty() ? 1 : 0;
                  case "pop":
                      return que.isEmpty() ? -1 : que.poll();
                  default:
                      return -2;
              }})
            .filter(r -> r != -2)
            .forEach(r -> {try {bw.write(r + "\n");} catch (Exception e) {};});
        bw.flush();
        bw.close();
        br.close();
    }
}
