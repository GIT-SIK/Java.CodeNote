package Code.Stream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TSpace1 {

    /* 실행 시간 측정 메소드 */
    public static void methodExecutionTimer(Runnable method, String methodName) {
        long start = System.currentTimeMillis();
        method.run();
        long end = System.currentTimeMillis();
        System.out.println(methodName + "의 실행 시간: " + (end - start) / 1000.0 + "초 \n");
    }


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


        /* Method Execution */
        methodExecutionTimer(() -> tListConcat(lsStr1, lsStr2), "tListConcat");
        methodExecutionTimer(() -> tListSum(lsInt1), "tListSum");
        methodExecutionTimer(() -> tListFilter(lsInt1),"tListFilter");

    }

    /* concat */
    static void tListConcat(List<String> ls1, List<String> ls2){
        /* 두 Stream을 합쳐서 대문자로 변환 후 출력합니다. */
        System.out.print("Concat : ");
        Stream.concat(ls1.stream(), ls2.stream()).map(String::toUpperCase).forEach(i -> System.out.print(i+ " "));
        ln();

    }

    static void tListSum(List<Integer> ls){
        /* reduce (Sum) -> ifPresent */
        /* 요소들을 람다식으로 두 인자를 받아 하나의 결과를 만들고 ifPresent 결과 여부를 확인 후 결과를 출력합니다.*/
        System.out.print("reduce O : ");
        ls.stream().reduce((i, j) -> i + j).ifPresent(temp -> System.out.println(temp));

        /* mapToInt -> Sum */
        /* Int 변환하여 Sum 메서드를 통해 결과를 출력합니다. */
        System.out.print("reduce X : " + ls.stream().mapToInt(Integer::intValue).sum());
        ln();

    }

    /* Filter */
    static void tListFilter(List<Integer> ls) {
        /* filter -> forEach */
        System.out.print("filter [item%3==0] : ");
        ls.stream().filter(item -> item%3==0).forEach(i -> System.out.print(i+ " "));
        ln();
    }






    /* ** println **  */
    static void ln(){
        System.out.println();
    }
}
