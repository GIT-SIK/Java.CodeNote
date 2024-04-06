import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        bw.write(Integer.toString(str.equals(new StringBuilder(str).reverse().toString()) ? 1 : 0));
        bw.flush();
        bw.close();
    }
}