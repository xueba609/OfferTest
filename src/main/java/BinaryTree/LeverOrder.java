package BinaryTree;
/*
*层序遍历
 */
import java.util.LinkedList;
import java.util.List;

public class LeverOrder {
    public void levelOrder(TreeNode root) {
        if(root==null){
            return ;
        }
        //将每一层的值存在链表队列中
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        queue.addLast(root);
        //当队列不为空的时候，就一直循环出
        while(!queue.isEmpty()){
            TreeNode front=queue.pollFirst();
            System.out.println(front.val);
            if(front.left!=null){
                queue.addLast(front.left);
            }
            if(front.right!=null){
                queue.addLast(front.right);
            }
    }
}

    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        TreeNode d=new TreeNode(4);
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=null;
        c.left=null;
        c.right=null;
        LeverOrder l=new LeverOrder();
        l.levelOrder(a);
    }
}
