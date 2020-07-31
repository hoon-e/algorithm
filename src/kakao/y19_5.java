package kakao;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class y19_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    /*
     * 5. 길 찾기 게임
     * 같은 레벨에 있는 노드는 같은 y좌표를 가진다.
     * 자식 노드의 y값은 항상 부모 노드보다 작다.
     * y좌표가 큰 값이 부모노드이다. y좌표가 같다면, x좌표가 작은 순서대로 정렬해야한다.
     */

    static int idx;
    static class Node {
        int id;
        int x, y;
        Node left;
        Node right;

        Node(int id, int x, int y){
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }

    static List<Node> nodes = new ArrayList<>();

    // Comparator 정의
    static Comparator<Node> comp = new Comparator<Node>(){
        public int compare(Node a, Node b){
            if(a.y == b.y)
                return a.x - b.x;
            return a.y - b.y;
        }
    };

    static void addNode(Node parent, Node child){
        if(child.x < parent.x){
            if(parent.left == null)
                parent.left = child;
            else
                addNode(parent.left, child);
        }else{
            if(parent.right == null)
                parent.right = child;
            else
                addNode(parent.right, child);
        }
    }

    public static void preOrder(int[][] answer, Node node){
        if(node == null) return;

        answer[0][idx++] = node.id;
        preOrder(answer, node.left);
        preOrder(answer, node.right);
    }

    public static void postOrder(int[][] answer, Node node){
        if(node == null) return;

        postOrder(answer, node.left);
        postOrder(answer, node.right);
        answer[1][idx++] = node.id;
    }

    public static int[][] solution(int[][] nodeinfo){
        int size = nodeinfo.length;

        // 노드를 새로 생성 - 정렬되지 않은 상태
        for(int i=0; i<size; i++)
            nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));

        // y가 큰 순서로, y가 같다면 x가 작은 순서대로 정렬한다.
        nodes.sort(comp);

        // root는 0번째 인덱스 값
        Node root = nodes.get(0);

        // 이진 트리 완성
        for(int i=1; i<size; i++){
            addNode(root, nodes.get(i));
        }

        int[][] answer = new int[2][size];
        preOrder(answer, root);
        idx = 0;
        postOrder(answer, root);
        return answer;
    }
}
