import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       IntStream.range(0, n).mapToObj(i ->
           IntStream.range(0, n)
               .map(j -> (n-1)-j)
               .mapToObj(j -> j > i ? " " : "*")
               .map(String::valueOf)
               .collect(Collectors.joining()))
       .forEach(System.out::println);
    }
}