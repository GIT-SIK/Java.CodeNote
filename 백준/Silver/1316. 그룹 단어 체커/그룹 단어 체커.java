
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long count = br.lines()
                .skip(1)
                .filter(l -> {
                    Set<Character> set = new HashSet<>();
                    char tc = ' ';
                    for (char ch : l.toCharArray()) {
                        if (ch != tc && set.contains(ch)) {
                            return false;
                        }
                        set.add(ch);
                        tc = ch;
                    }
                    return true;
                }).count();

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}