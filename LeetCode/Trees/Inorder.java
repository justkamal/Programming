package Trees;

import java.util.ArrayList;
import java.util.List;

public class Inorder {
    public static void main(String[] args) {
        Inorder mainObj = new Inorder();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(mainObj.inorderTraversal(treeNode));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(inorderList, root);
        return  inorderList;
    }

    private void inorder(List<Integer> inorderList, TreeNode root) {
        if (root != null) {
            if (root.left != null) inorder(inorderList, root.left);
            inorderList.add(root.val);
            if (root.right != null) inorder(inorderList, root.right);
        }
    }
}
