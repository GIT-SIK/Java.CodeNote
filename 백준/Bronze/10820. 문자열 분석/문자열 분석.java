import java.io.*;
import java.util.regex.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] patterns = {"[a-z]", "[A-Z]", "\\d", "\\s"};
        br.lines().parallel().forEach(r -> {
            try {
                for (String p : patterns) {
                    int c = 0;
                    Matcher matcher = Pattern.compile(p).matcher(r);
                    while (matcher.find()) {
                        c++;
                    }
                    bw.write(c + " ");
                }
                bw.newLine();
            } catch (Exception e) {}
        });
        bw.flush();
        bw.close();
    }
}
