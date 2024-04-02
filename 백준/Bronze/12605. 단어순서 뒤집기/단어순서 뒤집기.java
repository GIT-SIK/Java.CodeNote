import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] c = {0};
        br.lines()
            .takeWhile(l -> !l.isEmpty())
            .skip(1)
            .map(str -> str.split(" "))
            .forEach(r -> {
                try {
                    bw.write("Case #" + ++c[0] + ": ");
                    for (int i = r.length - 1; i >= 0; i--) {
                        bw.write(r[i]);
                        if(i!=0)
                            bw.write(" ");
                    }
                    bw.newLine();
                }
                catch(IOException e){}}
            );
        bw.flush();
        bw.close();
    }
}