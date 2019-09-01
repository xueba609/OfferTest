package FaceAndFace.JianOffer;

public class 栈的压入和弹出序列 {
    public static void main(String[] args) {
        int [] a={1,2,3,4,5};
        int [] b={5,4,3,1,2};
        System.out.println(IsPopOrder(a,b));
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        //如果长度不相等，返回false
        if(pushA.length!=popA.length){
            return false;
        }
        int n=pushA.length-1;
        int m=popA.length-1;
        //如果只有一个元素
        if(n==0){
            if(pushA[0]!=popA[0]){
                return false;
            }
        }
        //入栈从前到后，出栈从后到前
        //如果入栈的两个连续元素和出栈的两个元素相等，认为他们不符合
        //入栈后两个元素不需要再进行判断，因为不管顺序咋样都符合
        for(int i=0;i<=n-2;i++){
            for(int j=m-1;j>=0;j--){
                if(pushA[i]==popA[j]){
                    if(pushA[i+1]==popA[j+1]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
