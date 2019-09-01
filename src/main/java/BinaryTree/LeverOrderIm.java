package BinaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

        例如:
        给定二叉树: [3,9,20,null,null,15,7],
        返回其层次遍历结果：
        [
        [3],
        [9,20],
        [15,7]
        ]
        */
public class LeverOrderIm {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        class NodeLevel{
            //表示节点
            TreeNode node;
            //表示层数
            int level;

            public NodeLevel(TreeNode node,int level) {
                this.node = node;
                this.level=level;
            }
        }
        LinkedList<NodeLevel> queue=new LinkedList<>();
        queue.addLast(new NodeLevel(root,0));
        while(!queue.isEmpty()){
            NodeLevel front=queue.pollFirst();
            if(list.size()==front.level){
                //在list里面开辟一个空间
                list.add(new ArrayList<Integer>());
            }
            list.get(front.level).add(front.node.val);
            if(front.node.left!=null){
                queue.addLast(new NodeLevel(front.node.left,front.level+1));
            }
            if(front.node.right!=null){
                queue.addLast(new NodeLevel(front.node.right,front.level+1));
            }
        }
         return list;
    }

    private static void levelOrder2(TreeNode node){
        Queue<TreeNode> queue=new LinkedList<>();



        //完全二叉树，也是利用层序遍历，当遇见#则判断后面的节点是否都是#
    }

    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        TreeNode d=new TreeNode(4);
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=null;
        c.left=null;
        c.right=null;

        LeverOrderIm l=new LeverOrderIm();
        List<List<Integer>> list=l.levelOrder(a);
        System.out.println('{');
        for(List<Integer> list1 :list){
            System.out.print('{');
            for(int value:list1){
                System.out.print(value+" ");
            }
            System.out.println('}');
        }
        System.out.println('}');
    }
}
