import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");
        int v = Integer.parseInt(br.readLine());
        
        Long count = Arrays.stream(data)
            .mapToInt(Integer::parseInt)
            .filter(i -> i == v)
            .count();
        System.out.print(count);
    }
}