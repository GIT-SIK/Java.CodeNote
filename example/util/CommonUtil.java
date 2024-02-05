package example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.Field;
import java.util.List;

public class CommonUtil {

    /* JSON 유틸 */
    public static <T> ObjectNode toJson(T sourceObject, ObjectMapper objectMapper) {
        ObjectNode jsonNode = objectMapper.createObjectNode();
        Field[] fields = sourceObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                jsonNode.put(field.getName(), String.valueOf(field.get(sourceObject)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return jsonNode;
    }

    public static ArrayNode toJsonList(List<?> sourceList, ObjectMapper objectMapper) {
        ArrayNode arrayNode = objectMapper.createArrayNode();

        for (Object item : sourceList) {
            if (item != null) {
                if (item.getClass().isArray()) {
                    ArrayNode itemArrayNode = objectMapper.valueToTree(item);
                    arrayNode.add(itemArrayNode);
                } else {
                    ObjectNode itemNode = objectMapper.valueToTree(item);
                    arrayNode.add(itemNode);
                }
            }
        }

        return arrayNode;
    }


}
