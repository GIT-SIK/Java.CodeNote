/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/64063 */
/* 호텔 방 배정 */


package programmers.LV4.I;

import java.util.Arrays;

public class I1 {

    public static void main(String[] args){

        I1 i1 = new I1();
        long[] wantRoom = {1, 3, 4, 1, 3, 1};
        long maxRoom = 10L;
        System.out.println(Arrays.toString(i1.fillRoom(maxRoom, wantRoom)));
    }




    public long[] fillRoom(long k, long[] room_number) {

        long[] tempRoom = new long[Math.toIntExact(k)]; //방 저장용 배열
        long[] setRoom = new long[Math.toIntExact(k)]; //방 저장용 배열
        int count = 0;
        try {
            if (room_number.length > 200000) {
                throw new Exception("방 개수가 초과하였습니다.");
            }
            for(long rn : room_number) {
                for(int i=Math.toIntExact(rn); i<tempRoom.length; i++) {
                    if(tempRoom[i] == 0) {
                        tempRoom[i] = 1;
                        setRoom[count++] = i;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return setRoom;
    }

}
