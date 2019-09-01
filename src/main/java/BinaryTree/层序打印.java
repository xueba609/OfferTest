package BinaryTree;

import java.util.ArrayList;

public class 层序打印 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        //当队列为空的时候，就没有元素了
        while (queue.size() != 0) {
            //第一个节点出队列
            TreeNode temp = queue.remove(0);
            //如果第一个节点有左右孩子，入队列
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }
}
