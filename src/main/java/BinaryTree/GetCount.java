package BinaryTree;
/*
*获取二叉树节点个数
 */
//方法一：采用前序遍历（中序，后序）遍历的思想，每遍历一个＋1
//方法二：左子数+右子数+1的思想，空节点为0，一个节点为1，再进行遍历

public class GetCount {
    private static class Node{
        char value;
        Node left;
        Node right;
        Node (char value){
            this.value=value;
        }
    }
    private static int count=0;
    private static int count1(Node root){
        if(root!=null){
            count++;
            count1(root.left);
            count1(root.right);
        }
        return count;
    }
   private static int count2(Node root){
        if(root==null){
            return 0;
        }else if(root.left==null&&root.right==null){
            return 1;
        }else {
            return count2(root.left)+count2(root.right)+1;
        }
   }
   //返回叶子节点，递归过程中无需加上根的节点
    private static int leftCount(Node root){
        if(root==null){
            return 0;
        }else if(root.left==null&&root.right==null){
            return 1;
        }else {
            return leftCount(root.left)+leftCount(root.right);
        }
    }
    //获取第K层的节点个数,
    private static int kCount(Node root,int k){
        if(root==null){
            return 0;
        }else if(k==1){
            return 1;
        }else {
            return kCount(root.left,k-1)+kCount(root.right,k-1);
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
        int count1=count1(root);
        int count2=count2(root);
        int leftcount=leftCount(root);
        int kcount=kCount(root,3);
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(leftcount);
        System.out.println(kcount);
    }
}
