package DynamicPlaning;
/*在一个m*n的网格的左上角有一个机器人，机器人在任何时候只能向下或者向右移动，
        机器人试图到达网格的右下角，有多少可能的路径。
        */
public class uniquePaths {
    int uniquePaths1(int m,int n){
        if(n<0||m<0){
            return 0;
        }
       int [][] array=new int[m][n];
        // 初始化，第一行，第一列都为1
        for(int i=0;i<m;i++){
            array[i][0]=1;
        }
        for(int j=0;j<n;j++){
            array[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                array[i][j]=array[i-1][j]+array[i][j-1];
            }
        }
        return array[m-1][n-1];
    }

    public static void main(String[] args) {
        uniquePaths u1=new uniquePaths();
       System.out.println(u1.uniquePaths1(7,8));
    }
}
