package Sort;
//冒泡排序
/*
*两两比较，大的往后走
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] a={1,5,9,4,5,6,10};
         bubbleSort(a);
         for(int i:a){
             System.out.println(i);
         }
    }
    private static void bubbleSort(int[] a) {
        if(a.length==0){
            return;
        }
        int len=a.length;
        //注意边界，是两个两个比较i<len-1
            for(int i=0;i<len-1;i++){
                //用来记录是否已经有序，若已经有序，则直接跳出
                boolean flag=true;
            for(int j=0;j<len-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
