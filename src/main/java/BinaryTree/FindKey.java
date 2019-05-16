package BinaryTree;
/*
*查找key值
 */
//思路：递归 ，如果是根节点，返回根节点，如果不是在左子树里面找，左子树没有在右子树找
public class FindKey {
    private static class Node{
            char value;
            Node left;
            Node right;
            Node (char value){
                this.value=value;
            }
    private static Node findKey(Node root,char v){
                if(root==null){
                    return null;
                }
                //如果个节点找到了，返回根节点
                if(root.value==v){
                    return root;
                }
                //在左子树里面找
                Node r=findKey(root.left,v);
                if(r!=null){
                    return r;
                }
                //在右子树找
               r=findKey(root.right,v);
                if(r!=null){
                    return r;
                }
                return null;
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
            Node r=findKey(root,'E');
            System.out.println(r.value);
        }
    }
}
