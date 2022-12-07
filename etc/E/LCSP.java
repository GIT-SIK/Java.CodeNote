package etc.E;
/* DP구조 */
public class LCSP {

    public static void main(String[] args) {

        LCSP lcsp = new LCSP();
        char[] s = {'e','b','c','d','k'};
        char[] t = {'e','a','b','c','e'};

        char[] re = lcsp.LCSubstr(s,t);
        for(char r : re){
            System.out.print(r);
        }
    }

    public char[] LCSubstr(char[] S, char[] T) {

        int[][] L = new int[S.length][T.length]; // 각각 문자 위치에 따라 맞는 값을 몇번째까지 맞는지 저장하기 위해 선언
        int z = 0; // 문자열에서 각각 맞는 문자의 크기를 지정하기 위해 설정
        /*
        *  qabcdef : wabcfef 기준
        * abc가 각각 위치가 맞기떄문에 z는 3부여
        *
        *  */

        char[] ret = {}; // 문자열을 문자배열로 저장 :: 일치하는 문자을 저장하는 배열

        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < T.length; j++) {
                if (S[i] == T[j]) { // 해당 위치 문자가 같다면?
                    if (i == 0 || j == 0) // 0,0 배열값이 첫번째값이면 1로 설정
                        L[i][j] = 1;
                    else
                        L[i][j] = L[i - 1][j - 1] + 1; // 0,0배열외 값이면 그값에 1을 추가부여

                    /* 같은 문자를 저장 */
                    if (L[i][j] > z) { //z크기가 L보다 작으면 문자 :: 맞는문자가 더 증가했을 경우 z크기를 재설정한다.
                        /*
                        * abcde : abcfk 의 경우
                        * ab위치에서 z=2 저장된 상태
                        * =>  c=c를 비교할때 L의 값이 3이니 맞는 문자열길이를 z로 재설정
                         */
                        z = L[i][j]; // 맞는 위치의 값크기를 z로 저장
                        ret = new char[z]; // 일치하는 문자갯수만큼 크기 설정
                        for (int k = 0; k < z; k++)
                            ret[k] = S[i - z + 1 + k];
                    }
                    else if (L[i][j] == z) { // 앞에 문자보다 더 길게 일치하는 문자 경우
                        System.out.println(i + "," + j);
                        /*
                        * abcdIOP : abfkIOP 경우
                        * ab까지 2크기가 맞았지만 뒤에 IOP에서 IO가 일치하여 뒷문자가 더 길수 있으니 재설정
                         */
                        ret = new char[z]; // 일치하는 문자갯수만큼 크기 설정
                        for (int k = 0; k < z; k++)
                            ret[k] = S[i - z + 1 + k];
                    }


                } // 해당 각각 문자가 같지 않으면 0 부여
                else
                    L[i][j] = 0;
            }
        }

        for(int[] x : L){
            for(int y :x ) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        return ret; // 문자배열 반환 (C언어구조)
    }
}
