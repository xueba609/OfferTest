package Sort;

/*
*选择排序
* 一次遍历后，找到最大的和最小的分别和当前的第一个和当前的最后一个交换
 */
public class SelectSort {
    public static void main(String[] args) {
        int [] a={10,5,9,4,3,6,1};
        selectSort(a);
        for(int i:a){
            System.out.println(i);
        }
    }

    private static void selectSort(int[] a){
        int left=0;
        int right=a.length-1;
        while(left<right) {
            int min=left;
            int max=left;
            for (int i = left+1; i <= right; i++) {
                if(a[i]>a[max]){
                    max=i;
                }
                if (a[i]<a[min]){
                    min=i;
                }
            }
            swap(a,left,min);
            //这里要判断一下
            if(max==left){
              max=min;
            }
            swap(a,right,max);
            left++;
            right--;
        }
    }

    private static void swap(int[] a, int b, int c) {
        int temp=a[b];
        a[b]=a[c];
        a[c]=temp;
    }


}
