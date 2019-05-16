package BinaryTree;
/*
*获取二叉树的高度
 */
//思路 ：递归，左子树和右子树大的+1
public class GetHight {
    private static class Node{
        char value;
        Node left;
        Node right;
        Node (char value){
            this.value=value;
        }
    }
    private static int getHight(Node root){
        if(root==null){
            return 0;
        }else if(root.left==null&&root.right==null){
            return 1;
        }else{
            int left=getHight(root.left);
            int right=getHight(root.right);
            return (left>right?left:right)+1;
        }
    }
    private static Node createTestTree(){
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
        return a;
    }

    public static void main(String[] args) {
        Node root=createTestTree();
        int high=getHight(root);
        System.out.println(high);

    }
}
