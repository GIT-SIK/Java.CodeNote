import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int val = Integer.parseInt(br.readLine().split(" ")[1]);
            br.lines()
                .map(l -> l.split(" "))
                .flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt)
                .filter(i -> i < val)
                .forEach(r -> System.out.print(r + " "));
    }
}