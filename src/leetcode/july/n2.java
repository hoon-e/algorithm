package leetcode.july;

import java.util.*;

public class n2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int maxLevel = getHeight(root);

        for(int i=0; i<maxLevel; i++)
            ans.add(new ArrayList<>());

        traverseBottomUp(root, 0, ans, maxLevel-1);

        return ans;
    }

    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public void traverseBottomUp(TreeNode node, int level, List<List<Integer>> ans, int maxLevel) {
        if(node == null) return;

        traverseBottomUp(node.left, level + 1, ans, maxLevel);
        traverseBottomUp(node.right, level + 1, ans, maxLevel);

        ans.get(maxLevel-level).add(node.val);
    }
}
