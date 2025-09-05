import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
        int size =  Integer.parseInt(br.readLine());
        bw.write(
                 br.lines().flatMap(l -> Arrays.stream(l.split(" ")))
                 .map(Integer::parseInt)
                 .sorted(Comparator.reverseOrder())
                 .skip(size-1)
                 .findFirst()
                 .orElse(0)
            + ""
        );
        bw.flush();
        bw.close();
        br.close();
    }
}
