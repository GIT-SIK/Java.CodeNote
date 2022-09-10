/* 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/64061 */
/* 크레인 인형뽑기 게임 */

package Programmers.LV1.T;
import java.util.Stack;

public class T3 {

    public static void main(String[] args) {

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

       System.out.println(crane(board, moves));


    }

    public static int crane(int[][] board, int[] moves) {
        int popCount = 0;
        Stack<Integer> stack = new Stack<>();

        /* 크레인 */
        for (int m : moves) { // 뽑을 위치 반복문
            for (int j = 0; j < board.length; j++) {
                if (board[j][m-1] != 0) { // LIFO하기 위해 빈값이 아닌 값을 찾는 조건문
                    try { /* elementAt 오류 해결을 위한 try문 => 스택이 비어있으면 오류발생

                        /* --- 일치하는 값은 마지막값을 POP / 일치하지 않으면 배열값을 PUSH ---*/
                        if (stack.elementAt(stack.size() - 1) == board[j][m-1]) {
                            stack.pop();
                            popCount += 2;
                        } else {
                            stack.push(board[j][m-1]);
                        }

                        /* PUSH, POP으로 인해 사용된 배열 값 초기화 */
                        board[j][m-1] = 0;
                        break;
                    } catch(Exception e){
                        /* 스택값이 없으면 PUSH */
                        stack.push(board[j][m-1]);
                        board[j][m-1] = 0;
                        break;

                    }
                }
            }
        }


        return popCount;

    }

    /*  배열 출력 */
    public void printBoard(int[][] board) {

        for(int[] b : board){
            for(int c: b){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

