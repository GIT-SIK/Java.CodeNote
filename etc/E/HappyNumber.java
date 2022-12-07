package etc.E;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/* Happy Number */
public class HappyNumber {

    public static void main(String[] args) {
        HappyNumber Nh = new HappyNumber();
        boolean bool  = Nh.HappyNumber(85);
        if(bool){
            System.out.println("HAPPY");
        } else {
            System.out.println("UNHAPPY");
        }
    }

    public boolean HappyNumber(int number) {
        Set<Integer> dic = new HashSet<>();
        while (!dic.contains(number)) {
            dic.add(number);
            int temp = number;
            number = 0;
            while(temp!=0) {
                number += (temp % 10) * (temp % 10);
                temp /= 10;
            }
            if(number==1) {
                Print(dic);
                return true;
            }
        }
        Print(dic);
        return false;
    }

    public void Print(Set<Integer> dic){
        Iterator<Integer> it = dic.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}

