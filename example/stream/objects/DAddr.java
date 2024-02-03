package example.stream.objects;

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

}
