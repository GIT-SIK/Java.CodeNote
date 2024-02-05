package etc.I;

import java.util.ArrayList;
import java.util.List;

public class I1 {
    public static void main(String[] args){
        System.out.println(happy(19));
    }

    public static int happy(int number){

        int count=0;
        List<Integer> eq = new ArrayList<>();

        while(true) {
            int num=0;
            for (int i = 0; i < String.valueOf(number).length(); i++) {
                int k = String.valueOf(number).charAt(i)-48;
                num += k * k;
            }

            for(int e: eq){
                if(e==num){
                    return -1;
                }
            }
            eq.add(num);
            
            count++;
            if(num==1) {
                return count;
            } else {
                number = num;
            }
        }


    }
}
