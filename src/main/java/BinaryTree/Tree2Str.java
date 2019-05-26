package BinaryTree;
/*
你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
示例 1:

输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     
输出: "1(2(4))(3)"
解释: 原本将是“1(2(4)())(3())”，
在你省略所有不必要的空括号对之后，
它将是“1(2(4))(3)”。
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

public class Tree2Str {
    public String tree2str(TreeNode t) {
        if(t==null){
            return "";
        }
       StringBuilder sb=new StringBuilder();
        preOrderTree2Str(t,sb);
        //删除第一个和最后一个字符
        sb.delete(0,1);
        sb.delete(sb.length()-1,sb.length());
        return sb.toString();
    }
    private void preOrderTree2Str(TreeNode t, StringBuilder sb) {
        if(t!=null) {
            sb.append('(');
            //前序遍历
            sb.append(t.val);
            //如果左子树为空，右子树不为空加（）
            if(t.left==null&&t.left!=null){
                sb.append("()");
            }else{
                preOrderTree2Str(t.left, sb);
            }
            preOrderTree2Str(t.right,sb);
            sb.append(')');
        }
    }

    public static void main(String[] args) {
       TreeNode a=new TreeNode(1);
       TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        TreeNode d=new TreeNode(4);
       a.left=b;
       a.right=c;
       b.left=d;
        Tree2Str t=new Tree2Str();
        String str=t.tree2str(a);
        System.out.println(str);
    }
}
