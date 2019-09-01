package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
*前序遍历
 */
//思路：根左右的思想，递归思想
public class PreOrderTraversal {
    private static class Node{
        char value;
        Node left;
        Node right;
        Node (char value){
            this.value=value;
        }
    }
    private static void preOrderTraversal(Node root){
        if(root!=null){
            System.out.print(root.value+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    private static List<Character> preOrderTraversa2(Node root){
        if(root==null) {
        return new ArrayList<>();
        }
        List<Character> list=new ArrayList<>();
        list.add(root.value);
        List<Character> left=preOrderTraversa2(root.left);
        List<Character> right=preOrderTraversa2(root.right);
        list.addAll(left);
        list.addAll(right);
        return list;

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
        preOrderTraversal(root);
    }

}
