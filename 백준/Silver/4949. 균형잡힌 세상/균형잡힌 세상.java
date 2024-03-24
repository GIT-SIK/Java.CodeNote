import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       br.lines().takeWhile(l -> !l.isEmpty())
           .filter(s -> !s.equals("."))
           .map(s -> s.replaceAll("[a-zA-Z\\s.]",""))
           .map(s -> {
               Stack<Character> stack = new Stack<>();
               for(char c : s.toCharArray()) {
                   if(c == '(' || c == '[') {
                       stack.push(c);
                   } else if(c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                       return "no";
                   } else if(c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                       return "no";
                   }
               }
               return stack.isEmpty() ? "yes" : "no";
           }).forEach(System.out::println);
    }
}