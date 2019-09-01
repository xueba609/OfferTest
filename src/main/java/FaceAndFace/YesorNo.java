package FaceAndFace;

import java.util.Scanner;

public class YesorNo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //测试用例 个数
        int a=sc.nextInt();
        //数据个数
        int n=sc.nextInt();
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        String  b=yesOrNo(arr,n);
        System.out.format(b);
    }

    private static  String  yesOrNo(int[] arr, int n) {
        if(n<3&&n>100000){
            return "No";
        }
           for(int i=0;i<n;i++) {
               int j=i+2;
               int k=i+1;
               if (j >=n) {
                   j=j%n;
               }
               if(k>=n){
                   k=k%n;
               }
                   if ((arr[i] + arr[j]) < arr[k]) {
                       return "No";
                   }
               }
        return "Yes";
    }
}
