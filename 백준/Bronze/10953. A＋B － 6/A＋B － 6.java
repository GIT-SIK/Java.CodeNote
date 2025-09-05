import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       br.lines()
           .skip(1)
           .map(l -> Arrays.stream(l.split(","))
                .mapToInt(Integer::parseInt)
                .sum())
           .forEach(System.out::println);
       br.close();
    }
}

