package BinaryTree;
/*
*1.给定两个二叉树，编写一个函数来检验它们是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
2.判断两棵树是否是镜像对称二叉树
3.判断一棵树是对称树
 */
//思路：
// 判断他们的根是否相同，左右孩纸是否相同
public class IsSame{
    private static class Node {
       char val;
         Node left;
         Node right;
         Node(char x) {
            this.val = x;
         }
     }
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
    public static boolean isMirrorTree2(Node p,Node q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.val==q.val&&isMirrorTree2(p.left,q.right
        )&&isMirrorTree2(p.right,q.left);
    }
   private static  boolean isSymmetry(Node root){
        if(root==null){
            return true;
        }
      return isMirrorTree2(root.left,root.right);
    }

    public static void main(String[] args) {
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');

        Node e=new Node('A');
        Node f=new Node('C');
        Node g=new Node('B');
        Node h=new Node('D');
        a.left=b;a.right=c;
        b.left=d;
        e.left=f;e.right=g;
        g.right=h;
        System.out.println(isSameTree1(a,e));
        System.out.println(isMirrorTree2(a,e));
        System.out.println(isSymmetry(a));
    }
}
