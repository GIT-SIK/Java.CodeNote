package example.stream.code;

import example.stream.interfaces.TCode2Operations;
import example.util.TimeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TCode2 implements TCode2Operations {

    public static void main(String[] args) {
        TCode2 tc2 = new TCode2();

        /* Collect add */
        List<String> lsStr1 = Arrays.asList("AAA", "AABC", "AACD", "AAD", "AAAC", "AA", "GF", "AF");

        /* Method Execution */
        TimeUtil.methodExecutionTimer(() -> tc2.tListGroupingLength(lsStr1),"tListGroupingLength", true);
        TimeUtil.methodExecutionTimer(() -> tc2.tListGroupingChatAt(lsStr1),"tListGroupingChatAt", true);

        /* Method Execution Test Code */
        TimeUtil.methodExecutionTimer(() -> tc2.t1(lsStr1),"t1", true);
        TimeUtil.methodExecutionTimer(() -> tc2.t2(lsStr1),"t2", true);
    }

    /* [List] collect(groupingby) */
    public void tListGroupingLength(List<String> ls){
        /* 길이에 따른 그룹핑 */
        System.out.print(ls.stream().collect(Collectors.groupingBy(String::length)));

    }

    /* [List] collect(groupingby) */
    public void tListGroupingChatAt(List<String> ls){
        /* 첫 글자에 따른 그룹핑 */
        System.out.print(ls.stream().collect(Collectors.groupingBy(s -> s.charAt(0))));

    }


    /* Execution Time Test */
    public void t1(List<String> ls) {
        ls.stream()
                .collect(groupingBy(word -> word.chars().sorted()
                        .collect(StringBuilder::new,
                                (sb, value) -> sb.append((char) value),
                                StringBuilder::append)
                        .toString()))
                .values().stream()
                .filter(group -> group.size() >= 2)
                .map(group -> group.size() + ": " + group)
                .forEach(System.out::println);
    }

    public void t2(List<String> ls) {
        ls.stream()
                .collect(groupingBy(TCode2::alphabetize))
                .values().stream()
                .filter(group -> group.size() >= 2)
                .forEach(group -> System.out.println(group.size() +": " + group));
    }

    // Alphabet Sort
    public static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);;
        return new String(a);
    }
}