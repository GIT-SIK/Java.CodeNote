import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
        BigInteger[] read =  Arrays.stream(br.readLine().split(" "))
        .map(BigInteger::new)
        .toArray(BigInteger[] :: new);

        int rs = IntStream.range(2, read[1].intValue())
        .parallel()
        .filter(i -> read[0].mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO))
        .min()
        .orElse(0);

        bw.write(rs == 0 ? "GOOD" : "BAD " + rs);
        bw.flush();
        bw.close();
        br.close();
    }
}
