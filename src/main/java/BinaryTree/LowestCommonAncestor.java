package BinaryTree;
/*
*二叉树的最近祖先节点
 */
//思路：如果一个是root节点，则返回root
//      如果不是一颗子树的话，返回root；
//      如果在一颗子树的话，递归查找
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
           if(root==p||root==q){
               return root;
           }
           //判断p,q状态
           boolean pLeft=find(root.left,p);
           boolean pRight=find(root.left,q);
           //在左子树上
           if(pLeft&&pRight){
               return lowestCommonAncestor(root.left, p, q);
           }
           //在右子树上
           if(!pLeft&&!pRight){
               return lowestCommonAncestor(root.right, p, q);
           }
           return root;
    }
    private static boolean find(TreeNode root,TreeNode t){
        if(root==null){
            return false;
        }
        if(root==t){
            return true;
        }
        if(find(root.left,t)){
            return true;
        }
        if(find(root.right,t)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        TreeNode d=new TreeNode(4);
        a.left=b;
        a.right=c;
        b.left=d;
        LowestCommonAncestor l=new LowestCommonAncestor();
        System.out.println(l.lowestCommonAncestor(a,d,b).val);
    }
}
