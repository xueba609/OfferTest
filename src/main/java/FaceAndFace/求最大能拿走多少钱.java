package FaceAndFace;

import java.util.Scanner;

public class 求最大能拿走多少钱 {

        public static int SearchSum(int n,int [] array){
            if(n<=1){
                return 0;
            }
            //记录左边和
            int leftSum=array[0];
            int left_i=0;
            //记录右边和
            int rightSum = array[n-1];
            int right_i=n-1;
            //记录当前最大和
            int sum =0;
            while(left_i<right_i){
                if(leftSum<rightSum){
                    leftSum +=array[left_i+1];
                    left_i++;
                }else if(leftSum>rightSum){
                    rightSum +=array[right_i-1];
                    right_i--;
                }else{
                    sum=leftSum;
                    left_i++;
                    right_i--;
                }
            }
            return sum;
        }
        public static void main(String[] args){

            int [] array={1,3,5,4,5};
            System.out.println(SearchSum(5,array)) ;
        }

}
