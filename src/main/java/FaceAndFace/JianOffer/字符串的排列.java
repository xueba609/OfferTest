package FaceAndFace.JianOffer;
import java.util.ArrayList;
/*
*输入一个字符串,按字典序打印出该字符串中字符的所有排列。
* 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
/*
*思路：动态规划
 */
public class 字符串的排列 {
    public static void main(String[] args) {
        String s="abc";
        ArrayList<String> a=Permutation(s);
    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList=new ArrayList<>();
       String [] array=str.split("");
       if(array.length==0){
           return arrayList;
       }
       if(array.length==1){
           arrayList.add(array[0]);
       }
return null;
    }
}
