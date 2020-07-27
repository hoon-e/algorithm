package leetcode.july;

import java.util.*;

public class n27 {
    // inorder와 postorder 순회 결과
    int pIndex;
    Map<Integer, Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pIndex = postorder.length-1;

        for(int i=0; i<inorder.length; i++)
            index.put(inorder[i], i);

        return buildTreeByInPost(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode buildTreeByInPost(int[] inorder, int[] postorder, int start, int end) {
        // 시작점이 끝점보다 크게되는 경우 null을 리턴한다.
        if(start > end) return null;
        // pIndex의 값으로 노드를 생성
        TreeNode node = new TreeNode(postorder[pIndex--]);

        // start와 end가 같다면 더 이상 자식이 없는 것이므로 node를 리턴
        if(start == end) return node;

        // 현재 node의 위치를 찾는다.
        int pivot = index.get(node.val);
        // postorder는 오른쪽의 결과가 먼저 출력되므로, 오른쪽을 먼저 해준다.
        node.right = buildTreeByInPost(inorder, postorder, pivot + 1, end);
        node.left = buildTreeByInPost(inorder, postorder, start, pivot - 1);

        return node;
    }

    /* preorder와 inorder 순회 결과
    public void buildTreeByInPre(int[] inorder[], int[] preorder) {
        int pIndex = 0;

        root = buildTreeByInPre(inorder, preorder, 0, inorder.length-1, pIndex);
    }

    public TreeNode buildTreeByInPre(int[] inorder, int[] preorder, int start, int end, int pIndex) {
        if(start > end) return null;

        // preorder 방에서 하나 가져온다.
        TreeNode node = new TreeNode(preorder[pIndex++]);

        // start와 end index가 같다면, 해당 subtree에 node가 하나밖에 없다는 뜻이다.
        if(start == end) return TreeNode;

        // 그렇지 않다면, inorder방에서 해당 value를 가지고 있는 index를 탐색한다.
        int pivot = search(inorder, start, end, node.val);

        node.left = buildTreeByInPre(inorder, preorder, start, pivot-1, pIndex);
        node.right = buildTreeByInPre(inoder, preorder, pivot + 1, end, pIndex);

        return TreeNode;
    }
    */
}
