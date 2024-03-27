import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        for(char c : str.toCharArray()) {
            idx[c-97] = str.indexOf(c);
        }
        Arrays.stream(idx).forEach(r -> System.out.print(r + " "));
    }
}