import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] v = br.lines()
                .takeWhile(row -> !row.isEmpty())
                .map(r -> r.replaceAll(" ", "").toCharArray())
                .toArray(char[][] :: new);

        for(int i=0; i < Arrays.stream(v).mapToInt(c -> c.length).max().orElse(0); i++){
                for (int j = 0; j < v.length; j++) {
                    try {
                            System.out.print(v[j][i]);
                    } catch (Exception e) {}
                }
        }
    }
}