package DynamicPlaning;

public class Fibonacci {
   int  Fibonacci1(int n){
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        //F(1)
        int a=1;
        //F(2)
        int b=1;
        int sum=0;
        for(int i=3;i<=n;i++){
            //F(n)=F(n-1)+F(n-2)
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        Fibonacci fibonacci=new Fibonacci();
        int sum=fibonacci.Fibonacci1(15);
        System.out.println(sum);
    }
}
