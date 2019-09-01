package FaceAndFace.JianOffer;
/*
*输入两棵二叉树A，B，判断B是不是A的子结构。
* （ps：我们约定空树不是任意一个树的子结构）
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class 是否是子树 {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;


        TreeNode t8=new TreeNode(3);
        TreeNode t9=new TreeNode(6);
        TreeNode t10=new TreeNode(7);
        t8.left=t9;
        t8.right=t10;
        Boolean b =HasSubtree1(t1,t8);
        System.out.println(b);
    }

    public static boolean HasSubtree1(TreeNode root1, TreeNode root2) {
        if(root2==null) return false;
        if(root1==null && root2!=null) return false;
        boolean flag = false;
        if(root1.val==root2.val){
            flag = isSubTree(root1,root2);
        }
        if(!flag){
            flag = HasSubtree1(root1.left, root2);
            if(!flag){
                flag = HasSubtree1(root1.right, root2);
            }
        }
        return flag;
    }

   public static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null && root2!=null) return false;
        if(root1.val==root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }
        return false;
    }
}
