package etc.I;
/* 효율성 체크 부적합 : 누적합 사용 */

public class I2 {

    public static void main(String[] args) {
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int[][] skill = {{1,0,0,3,4,4}, {1,2,0,2,3,2}, {2,1,0,3,1,2},{1,0,1,3,3,1}};

        /*
        [type, r1, c1, r2, c2, degree]
        type
        1 -> Attack
        2 -> heal
        degree -> dam, heal;
         */

        System.out.println(map(board, skill));


    }

    public static int map(int[][] board, int[][] skill) {

        int[][] temp = new int [board.length][board[0].length];

        for(int i=0; i<skill.length; i++){
            if(skill[i][0] == 1) {
                    skill[i][5] = skill[i][5] * -1;
            }

            for(int r=skill[i][1]; r<=skill[i][3]; r++){
                for(int c=skill[i][2]; c<=skill[i][4]; c++){
                    temp[r][c] += skill[i][5];
                }
            }

        }

        int count = 0;

        for(int r=0; r< board.length; r++) {
            for(int c=0; c< board[r].length; c++) {
               board[r][c] += temp[r][c];
               if(board[r][c] > 0)
                   count ++;
            }
        }

        return count;
    }
}
