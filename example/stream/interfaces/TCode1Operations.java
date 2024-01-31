package example.stream.interfaces;

import java.util.List;

public interface TCode1Operations {

    /* [List] concat -> map -> forEach */
    void tListConcat(List<String> ls1, List<String> ls2);

    /* [List] reduce -> ifPresent */
    void tListSumReduce(List<Integer> ls);

    /* [List] mapToInt -> sum */
    void tListSumMapToInt(List<Integer> ls);

    /* [List] filter -> forEach */
    void tListFilter(List<Integer> ls);
}
