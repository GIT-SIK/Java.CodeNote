package programmers.LV1.I;


public class I11 {

    public static void main(String[] args) {

        System.out.println(solution("34566", "23"));
        System.out.println(solution("3141592","271"));
    }

    public static int solution(String t, String p) {
        int count = 0;
        for(int x=0; x<t.length()-(p.length()-1); x++){
            if(Long.parseLong(p) >= Long.parseLong(t.substring(x,x+p.length()))){
                count ++;
            }
        }
        return count;
    }
}
