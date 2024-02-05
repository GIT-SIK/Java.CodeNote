package example.stream.interfaces;

import example.stream.objects.DObj1;

import java.util.List;
import java.util.stream.Stream;

public interface TObject1Operations {

    /* [Stream] Filter -> map -> forEach */ /* 1회성 */
    void tStreamFilterIntV1(Stream<DObj1> Objs);

    /* [List] Filter -> map -> forEach */
    void tListFilterIntV1(List<DObj1> Objs);

    /* [List] forEach */
    void tListIfIntV1(List<DObj1> Objs);

    /* [List] sorted -> forEach */
    void tListSorted(List<DObj1> Objs);
}
