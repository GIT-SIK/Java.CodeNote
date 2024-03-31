import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stk = new Stack<>();
        br.lines().takeWhile(l -> !l.isEmpty()).skip(1).mapToInt(r -> {
            int[] arr = Arrays.stream(r.split(" ")).mapToInt(Integer::parseInt).toArray();
            switch (arr[0]) {
                case 2:
                    return !stk.empty() ? stk.pop() : -1;
                case 3:
                    return stk.size();
                case 4:
                    return !stk.empty() ? 0 : 1;
                case 5:
                    return !stk.empty() ? stk.peek() : -1;
                case 1:
                    stk.push(arr[1]);
            }
            return -2;
        }).forEach(r -> {
            if (r != -2) {
                try {
                    bw.write(r + "\n");
                } catch (IOException e) {}
            }
        });
        bw.flush();
        bw.close();
    }
}