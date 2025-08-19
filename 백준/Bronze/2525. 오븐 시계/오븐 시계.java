import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Calendar cal = Calendar.getInstance();

        int[][] t = br.lines()
                .map(r -> Arrays.stream(r.split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray()
                     )
                .toArray(int[][]::new);

        cal.set(Calendar.MINUTE, t[0][1]);
        cal.set(Calendar.HOUR_OF_DAY, t[0][0]);
        cal.add(Calendar.MINUTE, t[1][0]);
        
        bw.write(cal.get(Calendar.HOUR_OF_DAY) + " " + cal.get(Calendar.MINUTE));
        bw.flush();
        bw.close();
        br.close();
    }
}