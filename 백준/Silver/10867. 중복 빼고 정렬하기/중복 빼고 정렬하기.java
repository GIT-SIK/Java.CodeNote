import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines().skip(1).forEach(l -> Arrays.stream(l.split(" ")).mapToInt(Integer::parseInt).distinct().sorted().forEach(r -> System.out.print(r + " ")));
    }
}

