package BinaryTree;
/*
*给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
* s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 */
//思路：查找节点和判断是否是同一颗树  的结合
public class IsSubTree {
    private static class Node {
        char val;
        Node left;
        Node right;
        Node(char x) {
            this.val = x;
        }
    }
   //判断是否是相同的树
   public static boolean isSameTree1(Node p, Node q) {
       if(p==null&&q==null){
           return true;
       }
       if(p==null||q==null){
           return false;
       }
       return p.val==q.val&&isSameTree1(p.left,q.left
       )&&isSameTree1(p.right,q.right);
   }
   //查找，直接查找到那个点
    private boolean find(Node root,Node t){
        if(root==null){
            return false;
        }
        //判断是否是同一颗树
        if(isSameTree1(root,t)){
            return true;
        }
        //在左子树找
        if(find(root.left,t)==true){
            return true;
        }
        //在右子树找
        return find(root.right,t);
    }
    public boolean isSubtree(Node root,Node t){
        return find(root,t);
    }
}
