package FaceAndFace.JianOffer;
import java.util.ArrayList;
/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵：
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
则依次打印出数字
1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
/*
思路：定义四个变量，分别记录上行，下行，左列。右列。
当上《下，左《右，开始打印输
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args) {
       //int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] matrix={{1},{2},{3},{4},{5}};
        ArrayList<Integer> s=printMatrix(matrix);
        System.out.println(s);
    }
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        //保存元素
        ArrayList<Integer> array=new ArrayList<>();
        //如果数组为空，直接返回
        if(matrix.length==0){
            return array;
        }
        //如果是一个元素，添加直接返回
        if(matrix.length==1&&matrix[0].length==1){
            array.add(matrix[0][0]);
            return array;
        }
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        //记录当前高低左右
        int heap=0;
        int low=row;
        int left=0;
        int right=col;

        while(heap<=low&&left<=right){
            if(heap==low&&left==right){
                //处理数组中行列长度不相等的
                if(row==col) {
                    array.add(matrix[heap][low]);
                }
               break;
            }
            //从左到右
            for(int i=left;i<=right;i++){
                array.add(matrix[heap][i]);
            }

            //从上到下
            for(int i=heap+1;i<=low;i++){
                array.add(matrix[i][right]);
            }

            //从右到左 条件是高度不相等的情况

            if(heap!=low) {
                for (int i = right - 1; i >= left; i--) {
                    array.add(matrix[low][i]);
                }
            }
            //从下到上 条件是左右不相等的情况
            if(left!=right) {
                for (int i = low - 1; i >= heap + 1; i--) {
                    array.add(matrix[i][left]);
                }
            }
            right--;
            left++;
            heap++;
            low--;
        }
        return array;
    }
}
