package example.json.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import example.util.TimeUtil;
import example.util.CommonUtil;
import example.objects.DAddr;

import java.util.Arrays;
import java.util.List;


public class TJson {
    public static void main(String[] args) {
        TJson tj = new TJson();
        /* Collect add */
        List<DAddr> lsObjs = Arrays.asList(
                new DAddr(1, "KOREA", "SEOUL"),
                new DAddr(2, "KOREA", "BUSAN"),
                new DAddr(3, "KOREA", "DAEGU"),
                new DAddr(4, "KOREA", "SEOUL"),
                new DAddr(5, "JAPAN", "TOKYO"),
                new DAddr(6, "JAPAN", "FUKUOKA"),
                new DAddr(7, "JAPAN", "SAPPORO"),
                new DAddr(8, "JAPAN", "FUKUOKA"),
                new DAddr(9, "KOREA", "SEOUL")
        );
        TimeUtil.methodExecutionTimer(() -> tj.json(lsObjs),"json", true);

    }

    public void json(List<DAddr> lsObjs){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            /* type 1 */ /* List -> ArrayNode */
            ArrayNode jsonArrayUtil = CommonUtil.toJsonList(lsObjs,objectMapper);

            /* 출력 */
            System.out.println(
                    objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArrayUtil)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
