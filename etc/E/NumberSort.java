package etc.E;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/* 입력된 2개의 값을 각각 오름차순 내림차순으로 설정 후 더하여 출력한다. */
public class NumberSort {

    public static void main(String[] args) {

        NumberSort ns = new NumberSort();

        System.out.println(ns.Sum(2010, 20301));

    }


    public String Sum(int a, int b){

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        while(a > 0 || b > 0) {
            listA.add(a%10);
            listB.add(b%10);

            a/=10;
            b/=10;
        }
        Collections.sort(listA); //오름차순
        Collections.sort(listB, Collections.reverseOrder()); //내림차순

        int count = 0;
        for(int la : listA) {
            listB.set(count, listB.get(count) + la);
            count ++;
        }

        String number = "";
        for(int lb : listB) {
            number += lb + "";
        }
        return number;
    }

    public void print(List<Integer> list){

        System.out.println(Arrays.asList(list).toString());

    }
}
