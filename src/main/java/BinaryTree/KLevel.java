package BinaryTree;

//输出第K层有多少个节点
public class KLevel {
    int KLevel1(TreeNode root,int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        int left=KLevel1(root.left,k-1);
        int right=KLevel1(root.right,k-1);
        return left+right;
    }
}
