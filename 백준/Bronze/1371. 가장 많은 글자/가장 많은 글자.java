import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] al = new int[26];
        br.lines()
            .flatMapToInt(CharSequence::chars)
            .filter(c -> c != ' ')
            .forEach(c -> al[c-97]++);
        int max = Arrays.stream(al).max().orElse(0);
        for(int i=0; i < al.length; i++) {
            if (max == al[i])
                bw.write((char)(i+97));
        }
        bw.flush();
        bw.close();
    }
}