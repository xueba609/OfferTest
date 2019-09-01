package FaceAndFace;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //班级人数
        int n=sc.nextInt();
        //班级成绩
        int [] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        //需要查的人都个数
        int m=sc.nextInt();
        //查的具体某个人
        int [] array2=new int[m];
        for(int j=0;j<m;j++){
            array2[j]=sc.nextInt();
        }
        //开辟空间用于储存结果
        double [] temp=new double[m];
        search(n,array,m,array2,temp);
        for(int i=0;i<m;i++){
            System.out.format("%.6f\n",temp[i]*100);
        }
    }

    private static void search(int n, int[] array, int m, int[] array2, double[] temp) {
        //如果班级人数或查询人数为0，返回0
        if (n == 0 && m == 0) {
            return;
        }
        if(m>n){
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int person=array2[i];
            int count=0;
            for (int j = 0; j < n; j++) {
                //拿到的是某个人的成绩
                if (person < n) {
                    if (array[person] > array[j]) {
                        count++;
                    }
                }
                map.put(array2[i], count);
                System.out.println(map.get(array2[i]));
            }
        }
        for(int i=0;i<m;i++){
            temp[i]=map.get(array2[i]);
            System.out.println(map.get(array2[i]).doubleValue());
        }
    }
}
