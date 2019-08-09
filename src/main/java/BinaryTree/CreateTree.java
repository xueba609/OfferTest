package BinaryTree;


import java.util.Arrays;
import java.util.Stack;

/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
 */
//思路：递归。根据前序确定根节点 ，找到中序的根节点，分为左右子树，并拿到左右子树的前中序
//在左右子树继续找根节点和左右子树
public class CreateTree {
    private static class Node{
      int   value;
        Node left;
        Node right;
        Node (int  value) {
            this.value = value;
        }
    }
    private static int find6(int [] array,int v) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == v) {
                return i;
            }
        }
        return -1;
    }
    public static Node buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        //1.根据前序，找到根的值,
          int rootValue =preorder[0];
          Node root=new Node(rootValue);
          //2.在中序中找到根的值所在下标
          int leftSize=find6(inorder,rootValue);
          //3.找到左子树的前序和和中序

            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1+ leftSize);
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
            root.left = buildTree(leftPreorder, leftInorder);
            //3.找到右子树的前序和和中序
            int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);
            int[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, preorder.length);
            root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
    public static void main(String[] args) {
        int [] a={3,9,20,15,7};
        int [] b={9,3,15,20,7};
        CreateTree c=new CreateTree();
        Node d=c.buildTree(a,b);
        System.out.println(d);

    }
}
