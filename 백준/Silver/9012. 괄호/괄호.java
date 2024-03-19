import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] str = br.lines()
                    .takeWhile(l -> !l.isEmpty()).skip(1)
                    .map(s -> String.valueOf(s))
                    .toArray(String[]::new);

            Arrays.stream(str)
                    .map(Main::chkBracket)
                    .forEach(System.out::println);
    }

    public static String chkBracket(String str){
        Stack<Integer> stack = new Stack<>();
        for(char c: str.toCharArray()) {
            if(c == '(') {
                stack.push((int) c);
            } else if( c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return "NO";
            }
        }
        return !stack.isEmpty() ? "NO" : "YES" ;
    }
}
