import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int pick = Integer.parseInt(br.readLine().split(" ")[0]);
       String[] arrStr =  br.lines().limit(pick).toArray(String[] :: new);
       String[] arrStr2 =  br.lines().takeWhile(l -> !l.isEmpty()).toArray(String[] :: new);
       int[] c = {0};
       for(String str : arrStr) {
           Arrays.stream(arrStr2)
                   .forEach(r -> {
                           if(r.equals(str)) {
                                ++c[0];
                           }
                   });
       }
       System.out.println(c[0]);
    }
}