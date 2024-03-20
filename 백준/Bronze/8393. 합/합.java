        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
        import java.util.stream.*;
        public class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(IntStream.rangeClosed(1, Integer.parseInt(br.readLine())).sum());
            }
        }
