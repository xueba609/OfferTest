package BinaryTree;
/*
*给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
//思路：递归，左子树平衡，右子树平衡，左右子树高度差不大于1
public class IsBalanced {
    private static class Node {
        char val;
        Node left;
        Node right;
        Node(char x) {
            this.val = x;
        }
    }
    private boolean isBalanced(Node root){
        if(root==null){
            return true;
        }
        //左子数不平衡
        if(isBalanced(root.left)==false){
            return false;
        }
        //右子数不平衡
        if(isBalanced(root.right)==false){
            return false;
        }
        int left=height(root.left);
        int right=height(root.right);
        int s=left-right;
        if(s<-1||s>1){
            return false;
        }
        return true;
    }
    private int height(Node root) {
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right
        ))+1;
    }

    public static void main(String[] args) {
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        Node e=new Node('E');
        Node f=new Node('F');
        Node g=new Node('G');
        Node h=new Node('H');
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.left=f;c.right=g;
        e.right=h;
        IsBalanced I=new IsBalanced();
       System.out.println( I.isBalanced(a));
    }
}
