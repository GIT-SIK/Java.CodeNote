package CT2;

import java.util.ArrayList;
import java.util.List;

public class T1 {
    public static void main(String[] args) {

        T1 u = new T1();

        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(u.unique(arr));

        int[] arr2 = {4,4,3};
        System.out.println(u.unique(arr2));

    }
    public List<Integer> unique(int[] arr){
        List<Integer> answer = new ArrayList<>();
        boolean check;
        for(int i:arr){
            check = false;
            for(int j:answer) {
                if(i==j){
                    check = true;
                    break;
                }
            }
            if(check==false) {
                answer.add(i);
            }
        }
        return answer;
    }
}


