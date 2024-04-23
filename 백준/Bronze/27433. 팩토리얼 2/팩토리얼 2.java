import java.io.*;
import java.util.stream.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("" + IntStream.rangeClosed(1, Integer.parseInt(br.readLine()))
                      .mapToObj(BigInteger::valueOf)
                      .reduce(BigInteger.ONE, (x, y) -> x.multiply(y)));
        bw.flush();
        bw.close();
        br.close();
    }
}