import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(factorial(Integer.parseInt(br.readLine()))));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int factorial(int n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }
}