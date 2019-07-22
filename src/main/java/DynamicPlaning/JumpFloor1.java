package DynamicPlaning;
//JumpFloor一只青蛙一次可以跳上1级台阶，
// 也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

/* JumpFloor2一只青蛙一次可以跳上1级台阶，也可以跳上2级。
   求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。*/

/*
JumpFloor2我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class JumpFloor1 {
    int  JumpFloor(int n){
        if(n<=0){
           return 0;
        }
        //初始状态
        if (n==1){
            return 1;
        }
        int sum=1;
        /*for(int i=2;i<=n;i++){
            //F(n)=2*F(n-1）
            sum*=2;
        }*/
        sum=1<<(n-1);
        return sum;
    }
    int JumpFloor2(int n){
        if(n<=0){
            return 0;
        }
        if(n<=3){
            return n;
        }
        int a=2;
        int b=3;
        int sum=0;
        for(int i=4;i<=n;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
    public static void main(String[] args) {
       JumpFloor1 jumpFloor1=new JumpFloor1();
       int sum=jumpFloor1.JumpFloor(15);
        int sum2=jumpFloor1.JumpFloor2(15);
        System.out.println(sum2);
    }
}
