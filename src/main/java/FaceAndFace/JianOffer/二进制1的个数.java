package FaceAndFace.JianOffer;

import java.util.Scanner;

/*
*输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
/*
*思路：通过Interger提供的二进制方法得到
 */
public class 二进制1的个数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(NumberOf1(n));
    }

    private static int NumberOf1(int n) {
        char [] array=Integer.toBinaryString(n).toCharArray();
        int num=0;
        for(int i=0;i<array.length;i++){
            if(array[i]=='1'){
                num++;
            }
        }
        return num;
    }
}
