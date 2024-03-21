import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int i = Integer.parseInt(br.readLine());
            int[] c = {0};
            br.lines()
                    .takeWhile(l -> !l.isEmpty())
                    .mapToInt(row -> Arrays.stream(row.split(" ")).mapToInt(Integer::parseInt).sum())
                    .forEach(r -> System.out.println("Case #" + ++c[0] + ": " +  r));
    }
}