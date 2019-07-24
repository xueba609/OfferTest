package DynamicPlaning;
import java.util.Arrays;
public class uniquePathsWithObstacles {
    int uniquePathsWithObstacles(int [][] obstacles){
       if(obstacles==null){
           return 0;
       }
       int m=obstacles.length;
       int n=obstacles[0].length;
       //用来储存没一点的路径值
       int[][] temp=new int[m][n];
       //初始化，第一行，第一列的值若不为1（障碍），则到达的路径数为1
       for(int i=0;i<m;i++){
           if(obstacles[i][0]==1){
               break;
           }else {
               temp[i][0]=1;
           }
       }
        for(int j=0;j<n;j++){
            if(obstacles[0][j]==1){
                break;
            }else {
                temp[0][j]=1;
            }
        }
        for(int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if(obstacles[i][j]==1){
                    continue;
                }else {
                    temp[i][j]=temp[i-1][j]+temp[i][j-1];
                }
            }
        }
        return temp[m-1][n-1];
    }

    public static void main(String[] args) {
        uniquePathsWithObstacles u1=new uniquePathsWithObstacles();
        int [][] arrary={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(u1.uniquePathsWithObstacles(arrary));
    }
}
