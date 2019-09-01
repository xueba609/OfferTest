package BinaryTree;

public class 将二叉搜索树转换为有序的双向链表 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        //用来记录最后一个节点
        TreeNode lastNode=null;
        //头结点
        TreeNode preNode=convertNode(pRootOfTree,lastNode);

        while(preNode!=null&&preNode.left!=null)  {
            preNode=preNode.left;
        }
        return preNode;
    }
    public TreeNode convertNode(TreeNode pRootOfTree,TreeNode lastNode){
        //判断是否为空
        if(pRootOfTree==null){
            return null;
        }
        TreeNode cur=pRootOfTree;
        if(cur.left!=null)
            lastNode=convertNode(cur.left,lastNode);

        cur.left=lastNode;
        //如果最后一个节点不是空的话，将值放在最后一个节点的右边
        if(lastNode!=null){
            lastNode.right=cur;
        }
        //否则就是当前界定啊
        lastNode=cur;
        if(cur.right!=null)
            lastNode= convertNode(cur.right,lastNode);
        return lastNode ;
    }

}
