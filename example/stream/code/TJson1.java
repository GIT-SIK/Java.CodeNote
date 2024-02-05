package example.stream.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import example.stream.objects.DAddr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TJson1 {
    public static void main(String[] args) {
        try {
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

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            /* JSON 생성 (STREAM / 일반) */

            lsObjs.stream().map(dAddr -> dAddr.toJson(objectMapper)).forEach(jsonArray::add);

//            for (DAddr dAddr : lsObjs) {
//                ObjectNode jsonNode = dAddr.toJson(objectMapper);
//                jsonArray.add(jsonNode);
//            }

            /* JsonNode 출력 */
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
            System.out.println(jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
