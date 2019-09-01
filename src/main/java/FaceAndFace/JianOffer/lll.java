package FaceAndFace.JianOffer;

import java.util.Scanner;
import java.util.ArrayList;
public class lll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      //  String s=sc.next();
        String s="ji124356whd1234567";
        char [] array=s.toCharArray();

        int len=array.length;

        //用来记录右边的坐标
        int right=0;
        //用来记录最长
        int count=0;
        //用来记录最长
        int max=0;
        int i;
        if(len==0){
            System.out.print("");
        }
        for(i=1;i<len;i++){
            if(array[i-1]>='0'&&array[i-1]<='9'){
                count++;
                if(array[i]>'9'){
                    if(count>=max){
                        max=count;
                        right=i;
                        count=0;

                    }
                }
                if(array[i]>='0'&&array[i]<='9'){
                    if(count>=max){
                        max=count+1;
                        right=i+1;
                    }
                }
            }
        }
         System.out.println(max);
        for(int j=right-max;j<right;j++){
            System.out.print(array[j]);
        }
    }
}