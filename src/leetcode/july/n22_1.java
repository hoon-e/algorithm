package leetcode.july;

import java.util.*;

public class n22_1 {
    // Simple Code 1
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root==null)
            return result;

        explore(root, 0, result);
        return result;
    }

    public void explore(TreeNode root, int level, List<List<Integer>> result){
        if(root==null)
            return;

        if(result.size()==level){
            result.add(new ArrayList<Integer>());
        }

        if(level%2==0)
            result.get(level).add(root.val);
        else
            result.get(level).add(0, root.val);

        explore(root.left, level+1, result);
        explore(root.right, level+1, result);
    }

    // Other Simple Code
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();

        if(root==null)
            return res;
        q.add(root);
        boolean flag=true;

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>list=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();

                if(flag)
                    list.add(cur.val);
                else
                    list.add(0,cur.val);

                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }

            flag=!flag;
            res.add(list);
        }
        return res;
    }
}
