import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ls = br.lines().takeWhile(l -> !l.isEmpty()).mapToInt(Integer::parseInt).toArray();

        int mid = Arrays.stream(ls)
                .sorted()
                .skip((ls.length-1)/2)
                .limit(ls.length % 2 != 0 ? 1 : 2)
                .findFirst().orElse(-1);

        int avg = (int) Arrays.stream(ls)
                        .average()
                        .orElse(-1);

        System.out.println(avg + "\n" + mid);

    }
}