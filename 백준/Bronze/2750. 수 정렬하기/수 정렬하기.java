import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines()
            .skip(1)
            .takeWhile(l -> !l.isEmpty())
            .mapToInt(Integer::parseInt)
            .boxed()
            .distinct()
            .sorted()
            .forEach(System.out::println);
    }
}