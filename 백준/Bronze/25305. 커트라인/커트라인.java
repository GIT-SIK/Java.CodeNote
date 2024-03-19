import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine().split(" ")[1]);
        String[] x = br.readLine().split(" ");
        br.close();
        
        System.out.print(
            Arrays.stream(x)
            .map(Integer::parseInt)
            .sorted(Comparator.reverseOrder())
            .skip(k-1)
            .findFirst()
            .orElseThrow()
        );
        
    }
}
