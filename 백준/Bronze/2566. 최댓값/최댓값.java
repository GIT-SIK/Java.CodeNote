import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] flatIndex = {0};

        int[][] v = br.lines()
                .takeWhile(l -> !l.isEmpty())
                .map(l -> Arrays.stream(l.split(" "))
                         .mapToInt(Integer::parseInt)
                         .toArray()
                )
                .toArray(int[][] :: new);

        int max = Arrays.stream(v)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElseThrow();

        Arrays.stream(v)
                .flatMapToInt(Arrays::stream)
                .filter(i -> {
                    flatIndex[0]++;
                    return i == max;
                })
                .findFirst();

        System.out.println(max + "\n" + (int)Math.ceil((double)flatIndex[0]/v.length) + " " + (flatIndex[0]%v.length == 0 ? 9 : flatIndex[0]%v.length));
        
    }
}
