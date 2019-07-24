package DynamicPlaning;

public class minPathSum {
    int minPathSum1(int[][] grid){
        if(grid==null){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int [][]temp=new int[m][n];
        //初始化
        temp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            temp[i][0]=temp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){
            temp[0][j]=temp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                temp[i][j]=Math.min(temp[i-1][j],temp[i][j-1])+grid[i][j];
            }
        }
        return temp[m-1][n-1];
    }

    public static void main(String[] args) {
        minPathSum minPathSum =new minPathSum();
        int [][] arrary={{1,2,5},{2,1,9},{5,9,5}};
        System.out.println(minPathSum.minPathSum1(arrary));
    }
}
