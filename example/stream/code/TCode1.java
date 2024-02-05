package example.stream.code;

import example.stream.interfaces.TCode1Operations;
import example.util.TimeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TCode1 implements TCode1Operations {

        public static void main(String[] args) {
            TCode1 tc = new TCode1();

            /* Collect add */
            List<String> lsStr1 = new ArrayList<>(Arrays.asList("a", "b", "c"));
            List<String> lsStr2 = new ArrayList<>(Arrays.asList("e", "f", "g"));
            List<Integer> lsInt1 = new ArrayList<>(Arrays.asList(1, 2, 3));
            List<Integer> lsInt2 = new ArrayList<>(Arrays.asList(4, 5, 6));

            Stream<String> stStr1 = Stream.of("a", "b", "c");
            Stream<Integer> stInt1 = Stream.of(1, 2, 3);

            Stream<String> stEg1 = Stream.of(new String[] { "a", "b", "c" });
            Stream<String> stEg2 = Arrays.stream(new String[] { "a", "b", "c" });

            /* Method Execution */
            TimeUtil.methodExecutionTimer(() -> tc.tListConcat(lsStr1, lsStr2), "tListConcat",true);
            TimeUtil.methodExecutionTimer(() -> tc.tListSumReduce(lsInt1), "tListSumReduce",true);
            TimeUtil.methodExecutionTimer(() -> tc.tListSumMapToInt(lsInt1), "tListSumMapToInt",true);
            TimeUtil.methodExecutionTimer(() -> tc.tListFilter(lsInt1), "tListFilter",true);


            /* Method Execution (Return) */
            List<Integer> lsInt1r = new ArrayList<>();

            TimeUtil.methodExecutionTimer(() -> {
                lsInt1r.addAll(tc.trListFilter(lsInt1));
                System.out.print(lsInt1r);
            }, "trListFilter",true);

        }

        /* ** RETURN X ** */
        /* [List] concat -> map -> forEach */
        public void tListConcat(List<String> ls1, List<String> ls2) {
            /* 두 Stream을 합쳐서 대문자로 변환 후 출력합니다. */
            System.out.print("Concat : ");
            Stream.concat(ls1.stream(), ls2.stream()).map(String::toUpperCase).forEach(i -> System.out.print(i + " "));
        }

        /* [List] reduce -> ifPresent */
        public void tListSumReduce(List<Integer> ls) {
            /* 요소들을 람다식으로 두 인자를 받아 하나의 결과를 만들고 ifPresent 결과 여부를 확인 후 결과를 출력합니다. */
            System.out.print("reduce O : ");
            ls.stream().reduce((i, j) -> i + j).ifPresent(temp -> System.out.println(temp));
        }

        /* [List] mapToInt -> sum */
        public void tListSumMapToInt(List<Integer> ls) {
            /* Int 변환하여 Sum 메서드를 통해 결과를 출력합니다. */
            System.out.print("reduce X : " + ls.stream().mapToInt(Integer::intValue).sum());
        }

        /* [List] filter -> forEach */
        public void tListFilter(List<Integer> ls) {
            System.out.print("filter [item%3==0] : ");
            ls.stream().filter(item -> item % 3 == 0).forEach(i -> System.out.print(i + " "));
        }

        /* ** RETURN O ** */
        /* [List] filter -> forEach(return) */
        public List<Integer> trListFilter(List<Integer> ls){
            return ls.stream().filter(item -> item % 3 == 0).collect(Collectors.toList());
        }
    }
