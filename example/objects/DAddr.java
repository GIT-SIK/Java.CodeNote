package example.objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import example.util.CommonUtil;

public class DAddr {
    private int num;
    private String strCountry;
    private String strCity;

    public DAddr(int num, String country, String city ) {
        this.num = num;
        this.strCountry = country;
        this.strCity = city;
    }

    public int getNum(){
        return num;
    }

    public String getStrCountry(){
        return strCountry;
    }

    public String getStrCity(){
        return strCity;
    }

    // JSON (TJSON1.java)
    public ObjectNode toJson(ObjectMapper objectMapper) {
        /* 필드 인식으로 접근 */
        return CommonUtil.toJson(this, objectMapper);

        /* 직접적으로 접근 */
//        ObjectNode jsonNode = objectMapper.createObjectNode();
//        jsonNode.put("num", getNum());
//        jsonNode.put("strCountry", getStrCountry());
//        jsonNode.put("strCity", getStrCity());
//        return jsonNode;
    }

}
