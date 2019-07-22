package DynamicPlaning;

import java.util.ArrayList;
import java.util.List;

/*
*给定一个三角形，找到从上到下的最小路径总和。您可以移动到下面一行中相邻数字的每一步。

例如，给定以下三角形

[
     [ 2 ]，
    [ 3,4 ]，
   [6，5，7]，
  [4，1，8,3]
]

从上到下的最小路径总和为11（即，2 + 3 + 5 + 1 = 11）。
 */
public class minimumTotal {
    int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
       if(triangle.isEmpty()){
           return 0;
       }
        int[][] dp=new int[triangle.size()+1][triangle.size()+1];
        dp[0][0]=triangle.get(0).get(0);
       for(int i=1;i<triangle.size();i++){
           for(int j=0;j<=i;j++){
               //处理边界
               if(j==0){
                 dp[i][j]=dp[i-1][j];
               }else if (j==i){
                  dp[i][j]=dp[i-1][j-1];
               }
               else {
                   dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1]);
               }
               dp[i][j]=dp[i][j]+triangle.get(i).get(j);
           }
       }
       //到达最后一行元素，查看谁的数值最小
       int result=dp[triangle.size()-1][0];
       for(int i=1;i<triangle.size();i++){
           result=Math.min(dp[triangle.size()-1][i],result);
       }
       return result;
    }
    int minimumTotal2 (ArrayList<ArrayList<Integer>> triangle){
        int length=triangle.size();
        int[][] dp=new int[length+1][length+1];
        //获取最后一行元素
        for(int j=0;j<length;j++){
            dp[length-1][j]=triangle.get(length-1).get(j);
        }
        //从倒数第二行开始
        for(int i=length-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        minimumTotal minimumTotal=new minimumTotal();
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        list.add(-1);
        list1.add(2);
        list1.add(3);
        list2.add(1);
        list2.add(-1);
        list2.add(-3);
        triangle.add(list);
        triangle.add(list1);
        triangle.add(list2);
        System.out.println(minimumTotal.minimumTotal(triangle));
    }
    }
