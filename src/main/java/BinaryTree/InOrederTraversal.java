package BinaryTree;
/*
*中序遍历
 */
public class InOrederTraversal {
    private static class Node{
        char value;
        Node left;
        Node right;
        Node (char value){
            this.value=value;
        }
    }
    private static void inOrederTraversal(Node root){
        if(root!=null){
            inOrederTraversal(root.left);
            System.out.print(root.value+" ");
            inOrederTraversal(root.right);
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
        inOrederTraversal(root);
    }
}
