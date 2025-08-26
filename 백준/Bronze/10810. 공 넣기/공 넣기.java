import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] basket = new int[size[0]];

        br.lines()
            .map(r -> Arrays.stream(r.split(" ")).mapToInt(Integer::parseInt).toArray())
            .forEach(arr -> {
                Arrays.fill(basket, arr[0]-1, arr[1], arr[2]);
            });

        StringBuffer sb = new StringBuffer();
        
        for(int b : basket) {
            sb.append(b).append(" ");
        }
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
