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
    }

    /* [] Nested IntStream */
    public void tNestedIntStream() {
        IntStream.rangeClosed(1, 9)
                .mapToObj(i -> IntStream.rangeClosed(1, 9)
                        .map(j -> i + j)
                        .boxed()  // IntStream -> Stream<Integer>
                        .toArray(Integer[] :: new))
                .forEach(sum ->
                    System.out.println(Arrays.toString(sum)));
    }
}

