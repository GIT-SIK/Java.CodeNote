import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> std = br.lines().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        IntStream.rangeClosed(1, 30).filter(i -> !std.contains(i)).forEach(System.out::println);
        br.close();
    }
}