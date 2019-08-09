package Sort;
/*
*快速排序
* 选取一个基准值（取最右边的），左边的比他都小，右边的都比他大
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] a={1,5,9,4,5,6,10};
        quickSort(a,0,a.length-1);
        for(int i:a){

            System.out.println(i);
        }
    }

    private static void quickSort(int[] a,int left,int right) {
        if(left>=right){
            return;
        }
        int del=search(a,left,right);
        quickSort(a,left,del-1);
        quickSort(a,del+1,right);
    }

    private static int search(int[] a, int left, int right) {
        int begin=left;
        int end=right;
        int del=a[right];
        while(begin<end){
            //注意边界问题，a[begin]<=del要有=，
            // 如果没有碰见55555这种的会和下面的判断陷入死循环
            while(begin<end&&a[begin]<=del){
                begin++;
            }
            a[end]=a[begin];
            while(begin<end&&a[end]>=del){
                end--;
            }
            a[begin]=a[end];
        }
        //执行完，把del记得给a[begin]
        a[begin]=del;
        return begin;
    }
}