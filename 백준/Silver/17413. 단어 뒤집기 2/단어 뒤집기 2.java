import java.io.*;
import java.util.*;
import java.util.regex.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Matcher matcher = Pattern.compile("<[^>]*?>| |[^<\\s]+").matcher(br.readLine());
        List<String> divStr = new ArrayList<>(); 
        while (matcher.find()) {
            String mgs = matcher.group(0);
            StringBuffer sb = new StringBuffer(mgs);
                if(!mgs.startsWith("<")) {
                    sb.reverse();
                }
            divStr.add(sb.toString());
        }
        for(String ds : divStr) {
            bw.write(ds);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}