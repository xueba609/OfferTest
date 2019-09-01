package BinaryTree;
//最后一个节点是根节点
//从前往后找到根节点第一个大的节点，以此左边是左子树，右边是右子树

public class 判断数组是否是二叉搜索树的后序 {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length == 0) return false;
        //最后一个节点是根节点
        return isSearchTree(sequence,0,sequence.length-1);
    }

    private static boolean isSearchTree(int[] sequence, int start, int end) {
        if(end <= start){
            return true;
        }
        int i=start;
        for( ;i<end;i++){
            if(sequence[i]>sequence[end])
                break;
        }
        for(int j=i;j<end;j++){
            //如果在右子树里面发现比根大的，就返回false
            if(sequence[j]<sequence[end]){
                return false;
            }
        }
        return isSearchTree(sequence,0,i-1)&&isSearchTree(sequence,i,end-1);
    }

    public static void main(String[] args) {
        int [] a={7,4,6,5};
        System.out.println(VerifySquenceOfBST(a));
    }
}
