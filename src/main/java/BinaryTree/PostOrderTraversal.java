package BinaryTree;
/*
*后续遍历
 */
public class PostOrderTraversal {
    private static class Node{
        char value;
        Node left;
        Node right;
        Node (char value){
            this.value=value;
        }
    }
    private static void postOrderTraversal(Node root){
        if(root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value+" ");
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
        postOrderTraversal(root);
    }
}
