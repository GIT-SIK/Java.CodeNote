import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine().split(" ")[0]);
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = i+1;
        }

        int[][] rv = br.lines().map(r -> Arrays.stream(r.split(" "))
                                        .mapToInt(Integer::parseInt)
                                        .toArray())
                                .toArray(int[][] :: new);

        for(int[] ra :rv) {
            arr = reverse(arr, ra[0], ra[1]);
        }

        for(int a : arr) {
            bw.write(a + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] reverse(int[] arr, int s, int e) {
        if(s==e) {
            return arr;
        }
        List<Integer> tl = new ArrayList<>();
        for(int n: Arrays.copyOfRange(arr, s-1, e)){
            tl.add(n);
        }
        Collections.reverse(tl);
        
        for(int i=s-1, j=0; i<e; i++, j++) {
            arr[i] = tl.get(j);
        }
        return arr;
    }
}
