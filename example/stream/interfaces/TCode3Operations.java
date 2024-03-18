package example.stream.interfaces;

public interface TCode3Operations {

    /* [](mapToObj -> Boxed) Nested IntStream */
    void tNestedIntStream();

    /* [](flatMap) Nested IntStream */
    void tNestedIntStream2();

    /* [](forEach) Nested IntStream */
    void tNestedIntStream3();

    /* [](forEach+arr) Nested IntStream */
    void tNestedIntStream4(int[] arr, int[] arr2);
}
