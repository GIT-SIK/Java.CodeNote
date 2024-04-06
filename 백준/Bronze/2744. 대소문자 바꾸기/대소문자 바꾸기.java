import java.io.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(br.readLine().chars()
                .mapToObj(c -> String.valueOf(Character.isUpperCase(c) ? (char) Character.toLowerCase(c): (char) Character.toUpperCase(c)))
                .collect(Collectors.joining()));
        bw.flush();
        bw.close();
    }
}