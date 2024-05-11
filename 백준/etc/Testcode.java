import java.io.*;
import java.util.stream.*;

public class Testcode {
    /* 노드 */
    static class Node {
        String v;
        Node l, r;

        Node(String v) {
            this.v = v;
            this.l = null;
            this.r = null;
        }
    }

    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("백준/etc/input.txt"));
        int n = Integer.parseInt(br.readLine());

        IntStream.range(0, n).forEach(i -> {
            try {
                String[] arr = br.readLine().split(" ");
                addNode(arr[0], arr[1], arr[2]);
            } catch (Exception e) {
            }
            ;
        });

        printNode(root);
        br.close();
    }

    public static void addNode(String v, String l, String r) {
        if (root == null) {
            root = new Node(v);
        }
        if (!l.equals(".")) {
            root.l = new Node(l);
        }
        if (!r.equals(".")) {
            root.r = new Node(r);
        }

    }

    public static void printNode(Node node) {
        if (node == null)
            return;
        System.out.print(node.v + " ");
        printNode(node.l);
        printNode(node.r);
    }
}
