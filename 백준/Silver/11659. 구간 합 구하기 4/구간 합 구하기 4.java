import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int c = Integer.parseInt(br.readLine().split(" ")[1]);
       int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       Arrays.parallelPrefix(arr, (a,b)->a+b);
        for(int i=0; i<c; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken()) -1;
            int y = Integer.parseInt(tk.nextToken()) -1;
            System.out.println(arr[y] - (x == 0 ? 0 : arr[x-1]));
        }
    }
}