import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cc = {0};
        Map<Character, Long> map = br.readLine()
                .toUpperCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c,  Collectors.counting()));
        
        Object[] ch = map.entrySet().stream()
                .filter(e -> e.getValue().equals(map.values().stream()
                        .max(Long::compareTo)
                        .orElse(0L)))
                .peek(x -> ++cc[0])
                .filter(x -> cc[0] < 2)
                .map(Map.Entry::getKey).toArray();
        
        System.out.print(cc[0] > 1 ? "?" : ch[0]);
    }
}