package theory;

class Tree2{
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
        }
    }

    Node root;
    static int pIndex = 0; // 어디까지 읽었는지 저장

    public void buildTreeByInPre(int[] in , int[] pre){
        pIndex = 0;
        root = buildTreeByInPre(in, pre, 0, in.length-1);
    }

    // preorder와 inorder 배열로 tree 생성하기
    private Node buildTreeByInPre(int[] in, int[] pre, int start, int end){
        if( start>end ) return null; // start가 end를 뛰어넘으면 종료
        Node node = new Node(pre[pIndex++]);
        if( start == end ) return node; // start와 end가 같다면 node를 리턴
        int mid = search(in, start, end, node.data);
        // inorder 순서를 가지고있는 배열방에서 방 번호를 획득한다.
        node.left = buildTreeByInPre(in, pre, start, mid-1);
        node.right = buildTreeByInPre(in, pre, mid+1, end);
        return node;
    }

    // postorder와 inorder로 tree 생성하기
    public void buildTreeByInPost(int[] in, int[] post){
        //postorder는 뒤에서부터 노드데이터를 읽어오므로
        pIndex = post.length-1;
        root = buildTreeByInPost(in, post, 0, in.length-1);
    }

    private Node buildTreeByInPost(int[] in, int[] post, int start, int end){
        if(start>end) return null;
        Node node = new Node(post[pIndex--]);
        if(start==end) return node;
        int mid = search(in, start, end, node.data);

        // 왜 오른쪽 먼저?
        // postorder 저장될때는 왼쪽 오른쪽 루트이므로, 뒤에서부터 읽으면 루트 오른쪽 왼쪽이다.
        // 오른쪽 먼저 나오기때문에 반대로 해주어야한다.
        node.right = buildTreeByInPost(in, post, mid+1, end);
        node.left = buildTreeByInPost(in, post, start, mid-1);

        return node;
    }

    private int search(int[] arr, int start, int end, int data){
        int i;
        for(i=start; i<=end; i++){
            if(arr[i] == data) return i;
        }
        return i;
    }

    void printInorder(Node node){
        if(node==null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
public class tree_recover {
    public static void main(String[] args) {
        Tree2 tree = new Tree2();
        int[] pre = {4,2,1,3,6,5,7};
        int[] in = {1,2,3,4,5,6,7};
        int[] post = {1,3,2,5,7,6,4};

        tree.buildTreeByInPre(in,pre);
        tree.printInorder(tree.root);
        System.out.println(" ");
        tree.buildTreeByInPost(in, post);
        tree.printInorder(tree.root);
    }
}
