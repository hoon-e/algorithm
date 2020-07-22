package leetcode.july;

import java.util.*;

public class n22 {
    static List<List<Integer>> ans;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode dummy = root;

        ans = new ArrayList<List<Integer>>();
        traverse(root);

        return ans;
    }

    public static void traverse(TreeNode node) {
        boolean left = false;
        ArrayList<TreeNode> ptrs = new ArrayList<TreeNode>();
        ArrayList<Integer> vals = new ArrayList<>();

        if (node != null) {
            // 루트 값 추가
            ptrs.add(node);
            vals.add(node.val);
            ans.add(vals);

            while (true) {
                ArrayList<TreeNode> child = new ArrayList<>();
                vals = new ArrayList<>();

                for (TreeNode t : ptrs)
                    System.out.print(t.val + " ");
                System.out.println(left);

                // 왼쪽
                if (left) {
                    for (int i = ptrs.size() - 1; i >= 0; i--) {
                        TreeNode t = ptrs.get(i);

                        if (t.left != null) {
                            vals.add(t.left.val);
                            child.add(t.left);
                        }
                        if (t.right != null) {
                            vals.add(t.right.val);
                            child.add(t.right);
                        }
                    }

                    if (vals.size() != 0)
                        ans.add(vals);
                    left = false;
                    // 오른쪽
                } else {
                    for (int i = ptrs.size() - 1; i >= 0; i--) {
                        TreeNode t = ptrs.get(i);

                        if (t.right != null) {
                            vals.add(t.right.val);
                            child.add(t.right);
                        }

                        if (t.left != null) {
                            vals.add(t.left.val);
                            child.add(t.left);
                        }
                    }

                    if (vals.size() != 0)
                        ans.add(vals);
                    left = true;
                }

                if (child.size() == 0)
                    break;
                else {
                    ptrs = child;
                    child = null;
                }
            }
        }
    }
}
