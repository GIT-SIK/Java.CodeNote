        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
        import java.util.*;
        public class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int i = Integer.parseInt(br.readLine());
                br.readLine();
                System.out.print(
                    (i == br.lines()
                        .takeWhile(l -> !l.isEmpty())
                        .mapToInt(l -> Arrays.stream(l.split(" "))
                                .mapToInt(Integer::parseInt)
                                .reduce((a, b) -> a * b)
                                .orElse(0)
                                 )
                        .sum()
                    ) ? "Yes": "No");
            }
        }