package example.stream.interfaces;

import java.util.List;

public interface TCode2Operations {
    /* [List] collect(groupingby) */
    void tListGroupingLength(List<String> ls);

    /* [List] collect(groupingby) */
    void tListGroupingChatAt(List<String> ls);

    /* Execution Time Test */
    void t1(List<String> ls);
    void t2(List<String> ls);
}
