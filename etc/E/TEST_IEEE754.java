package etc.E;

public class TEST_IEEE754 {
    /* IEEE 754 TEST */
    public static void main(String[] args) {

        double dub = 1.12345688;
        float f1 = 1.123456f;
        float f2 = 1.1234568f;

        float ft1 = (float) dub;
        double dubt1 = (double) f1;
        double dub2 = 1.12345671;

        /* 부동소수처리에서 형 변환시 값이 정확하지 않음 */
        /* double -> float 문제없음 */
        /* float -> double 문제발생 */
        /* 1.1234568 -> 1.1234560012817... */

        System.out.println(ft1);
        System.out.println(dubt1);

        if(dubt1 > dub2) {
            System.out.println("SUCC");
        } else {
            System.out.println("FAIL");
        }


    }
}
