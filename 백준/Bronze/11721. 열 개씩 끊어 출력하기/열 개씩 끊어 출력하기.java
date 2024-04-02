import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(br.readLine().split("(?<=\\G.{10})")).forEach(System.out::println);
    }
}