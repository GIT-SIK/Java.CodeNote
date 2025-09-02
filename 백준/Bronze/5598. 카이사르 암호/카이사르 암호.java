import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));        
        for(char c : br.readLine().toCharArray()) {
            bw.write(c <= 'C' ? (char) (c+23) : (char) (c-3));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
