package Tester;

public class Soe {

    public static void main(String[] args){

        print(soe(120));
    }

    public static boolean[] soe(int num){

        boolean[] temp = new boolean[num+1];
        /*
         배열은 0부터 시작하기 때문에 크기 119까지 생성된다.
        그러므로 +1을 하여 크기 120까지 생성한다.
        */

        System.out.println("배열의 크기 : " + temp.length);

        for(int t=0; t<temp.length; t++){ /* 모든값 true로 변경 */
            temp[t] = true;
        }

        temp[0] = temp[1] = false; /* 0과 1은 제외 */

        for(int i=2; i*i<=num; i++){
            for(int j=i*i; j<=num; j+=i){
                temp[j] = false; /* 에라토스테네스의 체에 걸리는 값에 대해 false로 변경 (소수가 아닌)*/
            }
        }
        return temp;
    }

    public static void print(boolean[] bools) {
        int count = 0;
        for(boolean bool : bools){
            if(bool==true){ /* 소수인 값만 출력 */
                System.out.print(" " + count);
            }
            count ++;
        }
    }
}


