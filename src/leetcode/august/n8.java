package leetcode.august;

import java.util.*;
import java.io.*;

public class n8 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        // 각각 루트부터 시작, root.left부터 시작, root.right부터 시작하는 경우를 구한다.
        return getPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int getPath(TreeNode root, int sum) {
        if(root == null) return 0;

        int count = 0;
        sum -= root.val;

        // 만약 sum이 0이라면 count를 증가한다.
        if(sum == 0) {
            ++count;
        }

        // count를 각 경로마다 더해준다.
        count += getPath(root.left, sum);
        count += getPath(root.right, sum);

        return count;
    }
}
