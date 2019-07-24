package DynamicPlaning;
//有 n 个物品和一个大小为 m 的背包.
// 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
//问最多能装入背包的总价值是多大?
public class backPackII {
    int backPackII1(int m, int[] A, int[] V){
        //运行条件，必须有值
        if(A==null&&V==null&&m<1){
            return 0;
        }
        //多开辟一行一列用于存储初始值，A的大小，m的大小都代表真实的值
        int N=A.length+1;
        int M=m+1;
        //存储背包的价值
        int [][] result=new int[N][M];
        //第0行(表示没有物品），第0列（表示没有背包容量），因此价值都为0,
           for(int i=0;i<N;i++){
               result[i][0]=0;
           }
           for(int j=0;j<M;j++){
               result[0][j]=0;
           }
           for(int i=1;i<N;i++){
               for(int j=1;j<M;j++){
                   //如果第i商品的重量大于背包的容量，放不下，所以(i,j)的最大价值和(i-1,j)相同
                   //注意边界，循环从1开始的，因此A[0]=A[1-1]
                   if(A[i-1]>j){
                       result[i][j]=result[i-1][j];
                   }else {
                       //否则要么装，要么不装
                       //装
                       int a=result[i-1][j-A[i-1]]+V[i-1];
                       //不装
                       int b=result[i-1][j];
                       //在装与不装之间选出最大值
                       result[i][j]=Math.max(a,b);
                   }
               }
           }
           //返回装入前N个商品，物品大小为m的最大价值
        return result[N-1][m];
    }
    public static void main(String[] args) {

    }
}
