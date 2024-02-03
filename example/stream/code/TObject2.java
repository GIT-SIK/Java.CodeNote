package example.stream.code;

import example.stream.interfaces.TObject2Operations;
import example.stream.objects.DAddr;
import example.stream.util.TimeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TObject2 implements TObject2Operations {
    public static void main(String[] args) {
        TObject2 to2 = new TObject2();

        /* Object Collect add */
        DAddr obj1 = new DAddr(1, "KOREA", "SEOUL");
        DAddr obj2 = new DAddr(2, "KOREA", "BUSAN");
        DAddr obj3 = new DAddr(3, "KOREA", "DAEGU");
        DAddr obj4 = new DAddr(4, "KOREA", "SEOUL");
        DAddr obj5 = new DAddr(5, "JAPAN", "TOKYO");
        DAddr obj6 = new DAddr(6, "JAPAN", "FUKUOKA");
        DAddr obj7 = new DAddr(7, "JAPAN", "SAPPORO");
        DAddr obj8 = new DAddr(8, "JAPAN", "FUKUOKA");
        DAddr obj9 = new DAddr(9, "KOREA", "SEOUL");
        List<DAddr> lsObjs = new ArrayList<>(Arrays.asList(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9));

        /* Method Execution */
        TimeUtil.methodExecutionTimer(() -> to2.tListGroupingCountry(lsObjs), "tListGroupingCountry",true);
    }
    /* [List] collect(groupingby (mapping)) */
    public void tListGroupingCountry(List<DAddr> Objs){
        /* 국가에 따른 그룹핑 -> 출력 : 도시*/
        System.out.print(Objs.stream()
                .collect(Collectors.groupingBy(
                DAddr::getStrCountry,
                Collectors.mapping(DAddr::getStrCity, Collectors.toList())//,Collectors.mapping(..)
        )));
    }

}
