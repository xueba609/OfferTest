package BinaryTree;

import java.util.ArrayList;

public class 二叉树中和是某一路径 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> listArrayList=new ArrayList<>();
        if(root==null){
            return listArrayList;
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        find(listArrayList,arrayList,root,target);
        return listArrayList;
    }

    private void find(ArrayList<ArrayList<Integer>> listArrayList, ArrayList<Integer> arrayList, TreeNode root, int target) {
      //如果左右子树为空
        if(root.left==null&&root.right==null){
          arrayList.add(root.val);
          if(root.val==target){
              listArrayList.add(arrayList);
          }
          return;
      }
      //如果左右子树不为空根加入
      arrayList.add(root.val);
      //创立临时节点，保存当前到根的路径
        ArrayList<Integer> newArrayList=new ArrayList<Integer>();
        newArrayList.addAll(arrayList);

      if(root.left!=null){
          find(listArrayList,arrayList,root.left,target-root.val);
      }
      //一旦左树不符合，使用当时保存的数组
        if(root.right!=null){
          find(listArrayList,newArrayList,root.right,target-root.val);
        }

    }
}
