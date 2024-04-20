import java.io.*;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());
        String[] str = IntStream.range(0, h)
                .mapToObj(i -> {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < (h - i) - 1; k++) {
                        sb.append(" ");
                    }
                    for (int j = 0; j < (i * 2) + 1; j++) {
                        sb.append("*");
                    }
                    System.out.println(sb.toString());
                    return sb.toString();
                }).toArray(String[]::new);

        for (int i = str.length - 2; i >= 0; i--) {
            System.out.println(str[i]);
        }
        br.close();
    }
}
