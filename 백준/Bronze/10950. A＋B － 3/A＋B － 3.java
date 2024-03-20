        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.io.IOException;
        import java.util.*;
        public class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int n = Integer.parseInt(br.readLine());
                int[][] ls = br.lines().takeWhile(l -> !l.isEmpty()).map(l -> Arrays.stream(l.split(" ")).mapToInt(Integer::parseInt).toArray()).toArray(int[][] :: new);
                Arrays.stream(ls).map(rw -> Arrays.stream(rw).sum()).forEach(System.out::println);
            }
        }