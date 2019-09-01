package FaceAndFace;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true) {
            //零食的数目
            int N = sc.nextInt();
            //钱数
            int T = sc.nextInt();
            List<Integer> listmany=new ArrayList<>();
            List<Integer> listvalue=new ArrayList<>();
            int[] count=new int[N];
            for(int i=0;i<N;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                count[i]=sc.nextInt();
                if(count[i]>0){
                    for (int j = 0; j < count[i]; j++) {
                        listmany.add(a);
                        listvalue.add(b);
                    }
                }
            }
            System.out.println(backMax(T,listmany,listvalue));
        }
    }

    private static int backMax(int t,List<Integer> many,List<Integer> value) {
        //不能为空
      if(many==null&&value==null&&t<1){
          return 0;
      }
      //表示当前物品的钱数
      int M=many.size()+1;
      //表示当前剩下多少钱钱
      int T=t+1;
      //存储最大满意度
        int [][] result=new int[M][T];
        for(int i=0;i<M;i++){
            result[i][0]=0;
        }
        for(int j=0;j<T;j++){
            result[0][j]=0;
        }
        for(int i=1;i<M;i++){
            for(int j=1;j<T;j++){
                //如果第i个商品的钱>剩下的钱，则最大价值就是钱i-1个
                if(many.get(i-1)>j){
                    result[i][j]=result[i-1][j];
                }else {
                    //第i装
                    int a=result[i-1][j-many.get(i-1)]+value.get(i-1);
                    //第i不装
                    int b=result[i-1][j];
                    //选择最大的
                    result[i][j]=Math.max(a,b);
                }
            }
        }
        return result[M-1][t];
    }
}
