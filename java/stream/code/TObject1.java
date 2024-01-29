package java.stream.code;
import java.stream.interfaces.TObject1Operations;
import java.stream.objects.DObj1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.stream.util.TimeUtil;

public class TObject1 implements TObject1Operations {

    public static void  main(String[] args) {
        TObject1 to = new TObject1();

        /* Object Collect add */
        DObj1 obj1 = new DObj1(1,0, "Ob1-1", "Ob2-1");
        DObj1 obj2 = new DObj1(2,0, "Ob1-2", "Ob2-2");
        DObj1 obj3 = new DObj1(3,0, "Ob1-3", "Ob2-3");
        List<DObj1> lsObjs = new ArrayList<>(Arrays.asList(obj1, obj2, obj3));
        Stream<DObj1> streamObjs =Arrays.stream(new DObj1[] {obj1, obj2, obj3});

        /* Method Execution */
        TimeUtil.methodExecutionTimer(() -> to.tListFilterIntV1(lsObjs), "tListFilterIntV1",true);
        TimeUtil.methodExecutionTimer(() -> to.tListIfIntV1(lsObjs), "tListIfIntV1",true);
        TimeUtil.methodExecutionTimer(() -> to.tListSorted(lsObjs), "tListSorted", true);
    }


    /* [Stream] Filter -> map -> forEach */
    public void tStreamFilterIntV1(Stream<DObj1> Objs){
        Objs.filter(Obj -> Obj.getIntValue1() == 1 ).map(Obj -> Obj.getIntValue1()).forEach(r -> System.out.print("Filter Result : " + r));
    }

    /* [List] Filter -> map -> forEach */
    public void tListFilterIntV1(List<DObj1> Objs){
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
     * 결론 Stream 1회용이다.
     *
     *
     */


    /* forEach */
    public void tListIfIntV1(List<DObj1> Objs) {
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

    /* [List] sorted -> forEach */
    public void tListSorted(List<DObj1> Objs) {
        Objs.stream().sorted(Comparator.comparing(DObj1::getIntValue1).reversed()).forEach(r -> System.out.print(r.getIntValue1() + " "));
    }

}
