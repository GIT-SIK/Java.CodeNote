import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger[] nums =  Arrays.stream(br.readLine().split(" "))
        .map(n -> {
            BigInteger bi = new BigInteger(n);
            return bi;
        }).toArray(BigInteger[] :: new);
        bw.write(nums[0].modPow(nums[1],nums[2])+"");
        bw.flush();
        bw.close();
        br.close();
    }
}