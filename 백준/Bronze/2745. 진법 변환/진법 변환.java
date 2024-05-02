import java.io.*;
import java.math.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data = br.readLine().split(" ");
        int[] t = {1};
        BigInteger s = IntStream.range(0, data[0].length())
                .mapToObj(i -> data[0].charAt(data[0].length() - i - 1))
                .map(c -> {
                    BigInteger bi = BigInteger.valueOf(c >= 'A' ? (c - 'A' + 10) * t[0] : (c - '0') * t[0]);
                    t[0] *= Integer.parseInt(data[1]);
                    return bi;
                })
                .reduce(BigInteger.ZERO, BigInteger::add);
        bw.write(s + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
