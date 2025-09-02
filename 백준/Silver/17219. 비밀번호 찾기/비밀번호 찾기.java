import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, String> site = new HashMap<>();
        StringBuilder sb = new StringBuilder();    
        br.lines().skip(1).forEach(str -> {
            String[] read = str.split(" "); 
            try {
                site.put(read[0], read[1]);
            } catch (Exception e) {
                sb.append(site.get(read[0])).append("\n"); 
            }
        });
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
