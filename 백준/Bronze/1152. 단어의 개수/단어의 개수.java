import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            bw.write(String.valueOf(Arrays.stream(br.readLine().split(" "))
                                    .filter(s -> !s.equals(""))
                                    .count()
                                   )
                    );
        } catch (Exception e) {};
        bw.flush();
        bw.close();
        br.close();
    }
}
