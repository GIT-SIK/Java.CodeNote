package code.stream.object;

public class DObj1 {
    private int intValue1;
    private int intValue2;
    private String strValue1;
    private String strValue2;

    public DObj1(int iv1, int iv2, String sv1, String sv2 ) {
        this.intValue1 = iv1;
        this.intValue2 = iv2;
        this.strValue1 = sv1;
        this.strValue2 = sv2;
    }

    public int getIntValue1(){
        return intValue1;
    }

    public int getIntValue2(){
        return intValue2;
    }

    public String getStrValue1(){
        return strValue1;
    }

    public String getStrValue2(){
        return strValue2;
    }

}
