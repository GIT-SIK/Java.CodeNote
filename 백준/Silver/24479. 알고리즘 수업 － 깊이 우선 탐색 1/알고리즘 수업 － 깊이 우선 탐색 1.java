import java.io.*;
import java.util.*;
public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    static int[] check;
    static int od = 1;
    
    static class Node {
        int num;
        boolean visited;
        List<Node> neighbors;    
        
        Node(int n) {
            this.num = n;
            this.visited = false;
            this.neighbors = new ArrayList<>();
        }
        void sorted() {
            Collections.sort(this.neighbors, Comparator.comparingInt(n -> n.num));

        }

        void addNe(Node node){
            this.neighbors.add(node);
        }
    }

    public static void main(String[] args) throws IOException {
        int[] setting = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();        
        int n = setting[0]; 
        int m = setting[1]; 
        int v = setting[2];

        Node[] nodes = new Node[n+1];
        check = new int[n+1];
        
        for(int i=1; i<=n ;i++) {
            nodes[i] = new Node(i);
        }
        
        for(int i=0; i<m ; i++){
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();         
            nodes[line[0]].addNe(nodes[line[1]]);
            nodes[line[1]].addNe(nodes[line[0]]);
        }

        for(int i=1; i<=n; i++){
            nodes[i].sorted();
        }
      
        DFS(nodes[v]);
        
        for(int i=1; i<=n; i++){
            bw.write(check[i] + "");
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(Node node) throws IOException{
        node.visited = true;
        check[node.num] = od++;
        for(Node n : node.neighbors){
            if(!n.visited) {
                DFS(n);
            }
        }
    }
}
