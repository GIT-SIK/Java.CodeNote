import java.io.*;
import java.util.*;
public class DFS2 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    /*
     * 
     * DFS (Class Node ,재귀)
     * 
     */

    /*
     * INPUT ( DFS2Input.txt ) 
     * 첫줄 : 정점수 간선수 시작정점
     * 두번째줄~ : 정점간 정점간 연결 "1 2" 이면 1과 2가 연결되어있음.
     */

    static {
        try {
            br = new BufferedReader(new FileReader("DFS2Input.txt"));
        } catch (Exception e) {
            System.out.println("파일이 존재하지 않습니다.");
        }
    }

    static class Node {
        int num;
        boolean visited;
        List<Node> neighbors;    
        
        Node(int n) {
            this.num = n;
            this.visited = false;
            this.neighbors = new ArrayList<>();
        }

        void addNe(Node node){
            this.neighbors.add(node);
        }
    }

    public static void main(String[] args) throws IOException {
        int[] setting = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();        
        int n = setting[0]; // 정점수
        int m = setting[1]; // 간선수
        int v = setting[2]; // 시작 정점
        bw.write(n + " / " + m + " / " + v );
        bw.newLine();

        /* 정점수 초기화 */
        /* 0번 노드는 사용하지 않음. */
        Node[] nodes = new Node[n+1];

        /* 정점 노드 생성 */
        for(int i=1; i<=n ;i++) {
            nodes[i] = new Node(i);
        }
        /* 노드 간선 생성 */ 
        for(int i=0; i<m ; i++){
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            bw.write(line[0] + " / " + line[1]);
            bw.newLine();
            
            nodes[line[0]].addNe(nodes[line[1]]);
            nodes[line[1]].addNe(nodes[line[0]]);
        }

        DFS(nodes[v]);
        bw.flush();
    }

    static void DFS(Node node) throws IOException{
        node.visited = true;
        bw.write(node.num + " ");
        for(Node n : node.neighbors){
            if(!n.visited) {
                DFS(n);
            }
        }
    }
}
