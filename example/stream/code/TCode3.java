package example.stream.code;

import example.stream.interfaces.TCode3Operations;
import example.util.TimeUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TCode3 implements TCode3Operations {

    public static void main(String[] args) {
        TCode3 tc3 = new TCode3();

        /* Method Execution */
        TimeUtil.methodExecutionTimer(() -> tc3.tNestedIntStream(),"tNestedIntStream", true);
        TimeUtil.methodExecutionTimer(() -> tc3.tNestedIntStream2(),"tNestedIntStream2", true);
        TimeUtil.methodExecutionTimer(() -> tc3.tNestedIntStream3(),"tNestedIntStream3", true);

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 6, 7};
        TimeUtil.methodExecutionTimer(() -> tc3.tNestedIntStream4(arr1, arr2),"t+T+NestedIntStream4", true);
    }

    /* [](mapToObj -> Boxed) Nested IntStream */
    public void tNestedIntStream() {
        IntStream.rangeClosed(1, 9)
                .mapToObj(i -> IntStream.rangeClosed(1, 9)
                        .map(j -> i + j)
                        .boxed()  // IntStream -> Stream<Integer>
                        .toArray(Integer[] :: new))
                .forEach(sum ->
                    System.out.println(Arrays.toString(sum)));
    }

    /* [](flatMap) Nested IntStream */
    public void tNestedIntStream2() {
        IntStream.rangeClosed(1, 9)
                .flatMap(i -> IntStream.rangeClosed(1, 9)
                        .map(j -> i + j))
                .forEach(System.out::println);
    }

    /* [](forEach) Nested IntStream */
    public void tNestedIntStream3() {
        IntStream.rangeClosed(1, 9)
                .forEach(i -> {
                    IntStream.rangeClosed(1, 9)
                            .map(j -> i + j)
                            .forEach(System.out::println);
                });
    }

    /* [](forEach+arr) Nested IntStream */
    public void tNestedIntStream4(int[] arr, int[] arr2) {
        IntStream.range(0, arr.length)
                .forEach(i -> {
                    System.out.println();
                    IntStream.range(0, arr2.length)
                            .map(j -> arr[i] + arr2[j])
                            .forEach(r -> System.out.print(r + " "));
                });
    }

}

