package code.stream;
import code.stream.object.DObj1;

import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import code.stream.util.TimeUtil;

public class TObject {

    public static void  main(String[] args) {
        DObj1 obj1 = new DObj1(1,0, "Ob1-1", "Ob2-1");
        DObj1 obj2 = new DObj1(2,0, "Ob1-2", "Ob2-2");
        DObj1 obj3 = new DObj1(3,0, "Ob1-3", "Ob2-3");
        List<DObj1> lsObjs = new ArrayList<>(Arrays.asList(obj1, obj2, obj3));
        Stream<DObj1> streamObjs =Arrays.stream(new DObj1[] {obj1, obj2, obj3});

        TimeUtil.methodExecutionTimer(() -> tListFilterIntV1(lsObjs), "tListFilterIntV1",true);
        TimeUtil.methodExecutionTimer(() -> tListIfIntV1(lsObjs), "tListIfIntV1",true);
        TimeUtil.methodExecutionTimer(() -> tListSorted(lsObjs), "tListSorted", true);
    }


    /* Stream 타입 -> Fileter -> map -> forEach */
    static void tStreamFilterIntV1(Stream<DObj1> Objs){
        Objs.filter(Obj -> Obj.getIntValue1() == 1 ).map(Obj -> Obj.getIntValue1()).forEach(r -> System.out.print("Filter Result : " + r));
    }

    /* LIST 타입 -> Filter -> map -> forEach */
    static void tListFilterIntV1(List<DObj1> Objs){
        Objs.stream().filter(Obj -> Obj.getIntValue1() == 1 ).map(Obj -> Obj.getIntValue1()).forEach(r -> System.out.print("Filter Result : " + r));
    }

    /*
     *
     *   1.  List<DObj1> lsObjs = new ArrayList<>(Arrays.asList(obj1, obj2, obj3)); -> void method(List<DObj1> Objs){};
     *   2.  Stream<DObj1> streamObjs =Arrays.stream(new DObj1[] {obj1, obj2, obj3}); -> void method(Stream<DObj1> Objs){};
     *
     * 1. 와 2. 의 차이점은 매개변수 차이이다.
     * 하지만 더 큰 차이점은 ?
     * Stream으로 받는 경우 A메소드 => (Stream streamObjs) 처리 /  B메소드 -> (Stream streamObjs) 불가능
     * List으로 받을 경우 A메소드 => (List lsObjs -> Stream) 처리 / B메소드에서 (List lsObjs -> Stream) 가능
     * 결론 Stream 1회성이므로 다른 메소드에서 사용할 경우 Stream이 아닌 가공하기 전의 매개변수로 넣어 Stream으로 변경 후 처리하도록 한다.
     *
     *
     */


    /* forEach */
    static void tListIfIntV1(List<DObj1> Objs) {
        Objs.stream().forEach(obj -> {
            if (obj.getIntValue1() == 1) {
                System.out.print("IF Result : " + obj.getIntValue1() + " ");
            }
        });
    }

    /*
    *
    *  1. tListFilterIntV1() : Filter -> map -> ForEach
    *  2. tListIfIntV1() :ForEach(if)
    *
    *  0.035s
    *  0.015s
    *
    */

    static void tListSorted(List<DObj1> Objs) {
        Objs.stream().sorted(Comparator.comparing(DObj1::getIntValue1).reversed()).forEach(r -> System.out.print(r.getIntValue1() + " "));
    }

}
