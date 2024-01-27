package Code.Stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TSpace1 {

    public static void main(String[] args){
        /* Collect add */
        List<String> lsStr1 = new ArrayList<>(Arrays.asList("a","b","c"));
        List<String> lsStr2 = new ArrayList<>(Arrays.asList("e","f","g"));
        List<Integer> lsInt1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> lsInt2 = new ArrayList<>(Arrays.asList(4,5,6));

        Stream<String> stStr1 = Stream.of("a","b","c");
        Stream<Integer> stInt1 = Stream.of(1,2,3);

        Stream<String> stEg1 = Stream.of(new String[] {"a", "b", "c"});
        Stream<String> stEg2 = Arrays.stream(new String[] {"a", "b", "c"});


        /* Method */
         tConcat(lsStr1, lsStr2);
         tListSum(lsInt1);

    }

    /* concat */
    static void tConcat(List<String> ls1, List<String> ls2){
        Stream.concat(ls1.stream(), ls2.stream()).map(String::toUpperCase).forEach(System.out::println);
    }

    static void tListSum(List<Integer> ls1){
        /* reduce (Sum) -> ifPresent */
        System.out.print("reduce O : ");
        ls1.stream().reduce((i, j) -> i + j).ifPresent(temp -> System.out.println(temp));
        /* mapToInt -> Sum */
        System.out.println("reduce X : " + ls1.stream().mapToInt(Integer::intValue).sum());
    }

}
