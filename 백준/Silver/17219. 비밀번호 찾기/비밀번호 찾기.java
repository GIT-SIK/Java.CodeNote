import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, String> site = new HashMap<>();
        br.lines().skip(1).forEach(str -> { try {
                                              site.put(str.split(" ")[0],str.split(" ")[1]);
                                            } catch(Exception e) {
                                              try {
                                                bw.write(site.get(str.split(" ")[0]));
                                                bw.newLine();
                                              } catch(IOException ie) {}
                                            }
                                          }
                                   );
        bw.flush();
        bw.close();
        br.close();
    }
}
