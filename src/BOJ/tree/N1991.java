package BOJ.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
전위(preorder) : root -> left -> right
중위(inorder) : left -> root -> right
후위(postorder) : left -> right -> root
 */

class Node {
    String name;
    Node left, right;

    Node(String name){
        this.name = name;
    }
}

class Tree {
    Node root;

    public void addNode(String name, String leftNode, String rightNode){
        if(root == null){
            if(!name.equals(".")){
                root = new Node(name);
            }
            if(!leftNode.equals(".")){
                root.left = new Node(leftNode);
            }
            if(!rightNode.equals(".")){
                root.right = new Node(rightNode);
            }
        }else{
            findNode(root, name, leftNode, rightNode);
        }
    }

    private void findNode(Node root, String name, String leftNode, String rightNode){
        if(root == null) return;
        else if(root.name.equals(name)){
            if(!leftNode.equals(".")) root.left = new Node(leftNode);
            if(!rightNode.equals(".")) root.right = new Node(rightNode);
        }else{
            findNode(root.left, name, leftNode, rightNode);
            findNode(root.right, name, leftNode, rightNode);
        }
    }

    public void preOrder(Node root){
        System.out.print(root.name);
        if(root.left != null) preOrder(root.left);
        if(root.right != null) preOrder(root.right);
    }

    public void inOrder(Node root){
        if(root.left != null) inOrder(root.left);
        System.out.print(root.name);
        if(root.right != null) inOrder(root.right);
    }

    public void postOrder(Node root){
        if(root.left != null) postOrder(root.left);
        if(root.right != null) postOrder(root.right);
        System.out.print(root.name);
    }
}

public class N1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Tree tree = new Tree();
        int test = Integer.parseInt(br.readLine());

        while(test-- > 0){
            String[] line = br.readLine().split(" ");
            tree.addNode(line[0], line[1], line[2]);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}
