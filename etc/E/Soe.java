package etc.E;

public class Soe {

    public static void main(String[] args){

        print(soe(120));

        System.out.println();
        System.out.println(soe2(120));


    }


    /* 0 ~ 입력값 사이에 있는 모든 소수 출력 */
    public static boolean[] soe(int num){

        boolean[] temp = new boolean[num+1];
        /*
         배열은 0부터 시작하기 때문에 크기 119까지 생성된다.
        그러므로 +1을 하여 크기 120까지 생성한다.
        */


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

    /* 입력된 값이 소수인지 확인 */

    public static boolean soe2(int num) {
        /* 0과 1은 제외 */
        if (num == 0 || num == 1)
            return false;
        // 제곱근 만들기
        int lim = (int)Math.sqrt(num);
        double dLim = Math.sqrt(num);
        System.out.println(dLim + " : " + lim);

        // 제곱근 부여값에 따라 순환
        for (int i = 2; i <= lim; i++) {
            if (num % i == 0)
                return false;

        }
        return true;
    }

}


