import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines()
            .skip(1)
            .takeWhile(l -> !l.isEmpty())
            .filter(s -> {
                    try {
                        Integer.parseInt(s);
                    } catch (Exception e) {
                        return true;
                    }
                return false;
            })
            .distinct()
            .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
            .forEach(System.out::println);
    }
}
