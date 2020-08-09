package leetcode.august;

import java.util.*;
import java.io.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}

class Node implements Comparable<Node> {
    int depth;
    int value;

    Node(int depth, int value) {
        this.depth = depth;
        this.value = value;
    }

    public int compareTo(Node n) {
        if(depth < n.depth)
            return -1;
        else if(depth == n.depth) {
            return value - n.value;
        } else
            return 1;
    }
}

public class n7 {
    Map<Integer, ArrayList<Node>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ArrayList<Node> tmp;
        ArrayList<Integer> answer;
        map = new TreeMap<Integer, ArrayList<Node>>();

        getList(root, 0, 0);

        for(Integer key: map.keySet()) {
            tmp = map.get(key);
            Collections.sort(tmp);

            answer = new ArrayList<>();

            for(Node n : tmp) answer.add(n.value);
            ans.add(answer);
        }

        return ans;
    }

    public void getList(TreeNode root, int x, int depth) {
        if(root == null) return;

        ArrayList<Node> tmp = map.getOrDefault(x, new ArrayList<Node>());
        tmp.add(new Node(depth, root.val));

        map.put(x, tmp);

        getList(root.left, x-1, depth+1);
        getList(root.right, x+1, depth+1);
    }
}
