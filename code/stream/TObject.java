package code.stream;
import code.stream.object.DObj1;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import code.stream.util.TimeUtil;

public class TObject {

    public static void  main(String[] args) {
        DObj1 obj1 = new DObj1(1,0, "Ob1-1", "Ob2-1");
        DObj1 obj2 = new DObj1(2,0, "Ob1-2", "Ob2-2");
        DObj1 obj3 = new DObj1(3,0, "Ob1-3", "Ob2-3");

        Stream<DObj1> Objs =Arrays.stream(new DObj1[] {obj1, obj2, obj3});

        TimeUtil.methodExecutionTimer(() -> tListFilterIntV1(Objs), "tListFilterIntV1",true);
    }

    /* Filter -> map -> forEach */
    static void tListFilterIntV1(Stream<DObj1> Objs){
        Objs.filter(Obj -> Obj.getIntValue1() == 1 ).map(Obj -> Obj.getIntValue1()).forEach(r -> System.out.print("Result : " + r));

    }
}
