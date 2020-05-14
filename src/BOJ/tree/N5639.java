package BOJ.tree;

import java.io.*;
import java.util.*;

class Elements {
    int idx;
    Elements left, right;

    Elements(int idx){
        this.idx = idx;
    }
}

class binaryTree {
    Elements root;

    public void addTree(int idx){
        if(root == null){
            root = new Elements(idx);
        }else {
            if(root.idx > idx) {
                if(root.left == null){
                    root.left = new Elements(idx);
                }
                else
                    nextNode(root.left, idx);
            }
            else if(root.idx < idx){
                if(root.right == null){
                    root.right = new Elements(idx);
                }
                else
                    nextNode(root.right, idx);
            }
        }
    }

    public void nextNode(Elements cur, int idx) {
        if (cur.idx > idx) {
            if (cur.left == null) {
                cur.left = new Elements(idx);
            }
            else
                nextNode(cur.left, idx);
        }
        else if(cur.idx < idx){
            if(cur.right == null) {
                cur.right = new Elements(idx);
            }
            else
                nextNode(cur.right, idx);
        }
    }

    public void postOrder(Elements cur){
        if(cur == null) return;

        postOrder(cur.left);
        postOrder(cur.right);
        System.out.println(cur.idx);
    }
}

public class N5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        binaryTree bT = new binaryTree();
        String num;

        while((num=br.readLine()) != null && num.length() != 0){
            bT.addTree(Integer.parseInt(num));
        }

        bT.postOrder(bT.root);
    }
}
