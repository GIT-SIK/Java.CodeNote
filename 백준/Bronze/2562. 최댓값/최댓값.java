import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             int[] ls = br.lines()
                    .takeWhile(l -> !l.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int max = Arrays.stream(ls).max().orElseThrow();
            System.out.print(max + "\n" + (1 + IntStream.range(0, ls.length).filter(i -> ls[i] == max).findFirst().orElse(-1)));
    }
}