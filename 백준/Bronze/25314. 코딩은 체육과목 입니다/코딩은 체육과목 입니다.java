import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1,(i/4)).forEach(r -> {
            sb.append("long ");
            if(r == i/4) {
                sb.append("int");
            }
        });
        System.out.print(sb.toString());
    }
}