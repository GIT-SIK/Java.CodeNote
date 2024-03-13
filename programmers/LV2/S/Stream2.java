package programmers.LV2.S;

public class Stream2 {

    public static void main(String[] args) {
        /* 문제 ( 단, Stream을 활용하여 풀 것.) */
        /* 방문 길이
        * (-5, -5) ~ (5, 5) 크기에서 캐릭터가 움직이려한다.
        * U : 윗키 / D : 아랫키 / R : 오른쪽키 / L : 왼쪽키
        * 키값은 String으로 받아 순서대로 클릭하게 된다.
        * 키를 눌러 캐릭터가 움직이는 길을 카운트를 한다.
        * 단, 이미 지나갔던 길과 크기를 벗어날 경우 카운트에서 제외한다.
        *
        * 예시 : UDU의 경우 이동이 2번이 발생했지만 같은 길을 걸었기 때문에 1번이다.
        * 예시 : LULLLLLL의 경우 이동이 7번이 발생했지만 크기에 걸려 6번이다.
        */
        Stream2 st2 = new Stream2();
        System.out.println(st2.solution("ULURRDLLU"));
        System.out.println(st2.solution("LULLLLLLU"));

        System.out.println(st2.solution("UDU"));
        System.out.println(st2.solution("LULLLLLL"));
    }

    class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(String dirs) {
        Pos p = new Pos(0,0);
        return (int) dirs.chars().mapToObj(c -> {
                    if(p.x < 5 && c == 'R') {
                        return "" + (++p.x - 0.5) + p.y;
                    }
                    if(p.x > -5 && c == 'L') {
                        return "" + (--p.x + 0.5) + p.y;
                    }
                    if(p.y < 5 && c == 'U') {
                        return "" + p.x + (++p.y - 0.5);
                    }
                    if(p.y > -5 && c == 'D') {
                        return "" + p.x + (--p.y + 0.5);
                    }
                    return "";
                })
                .filter(s -> !s.isEmpty())
                .distinct()
                .count();
    }
}