package example.stream.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import example.objects.DAddr;

import java.util.Arrays;
import java.util.List;

public class TJson1 {

    public static void main(String[] args) {
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

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            /* type 2 */
            /* JSON 생성 */ /* List -> ObjectNode -> ArrayNode */
            ArrayNode jsonArray = objectMapper.createArrayNode();
            
            /* Stream */
            lsObjs.stream().map(dAddr -> dAddr.toJson(objectMapper)).forEach(jsonArray::add);

            /* 일반 
            for(DAddr dAddr : lsObjs){
                ObjectNode jsonNode = dAddr.toJson(objectMapper);
                jsonArray.add(jsonNode);
            }
            */
            
            /* 출력 */
            System.out.println(
                    objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
