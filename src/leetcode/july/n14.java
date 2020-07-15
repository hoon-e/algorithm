package leetcode.july;

import java.io.*;
import java.util.*;

public class n14 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode( int val ) {
            this.val = val;
        }

        TreeNode( int val, TreeNode left, TreeNode right ) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static ArrayList[] nodes;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        nodes = new ArrayList[2];

        for(int i=0; i<2; i++)
            nodes[i] = new ArrayList<String>();

        inOrder(p, 0);
        inOrder(q, 1);

        if(nodes[0].size() == nodes[1].size()){
            for(int i=0; i<nodes[0].size(); i++){
                if(!nodes[0].get(i).equals(nodes[1].get(i)))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public void inOrder(TreeNode t, int idx){
        if(t != null){
            nodes[idx].add(String.valueOf(t.val));
            inOrder(t.left, idx);
            inOrder(t.right, idx);
        }
        else {
            nodes[idx].add("null");
        }
    }
}
