import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stk = new Stack<>();
        br.lines()
            .takeWhile(l -> !l.isEmpty())
            .skip(1)
            .mapToInt(Integer::parseInt)
            .forEach(r -> {
                if (r == 0) {
                    stk.pop();
                } else {
                    stk.push(r);
                }
            });
        int sum = 0;
        for(Integer i:stk) {
            sum += i;
        }
        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }
}