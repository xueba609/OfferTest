package Sort;



/*
*堆排序
* 先建大堆，堆顶与最后一个元素交换。重新建堆
 */
public class HeapSort {
    public static void main(String[] args) {
        int [] a={1,2,9,4,5,6,10};
        heapSort(a);
        for(int i:a){
            System.out.println(i);
        }
    }
    private static void heapSort(int[] a) {
             //创建大堆
    //如果建小堆，则堆顶会被破坏，要重新建堆，代价很大
             createHeap(a);
             for(int i=0;i<a.length;i++){
                 //堆顶元素和最后一个元素交换，堆元素-1；
                 swap(a,0,a.length-i-1);
                 //重新调整的数组长度为a.length-i-1，在进行调整为大堆
                 adjustHeap1(a,a.length-i-1,0);
             }
    }

    private static void createHeap(int[] a) {
        int len=a.length;
        for(int i=len/2-1;i>=0;i--){
            adjustHeap1(a,len,i);
        }
    }

    private static void adjustHeap1(int[] a, int len, int root) {
        int leftChild=root*2+1;
        int rightChild=root*2+2;
        //如果左孩子>len，数组越界
        if(leftChild>=len){
            return;
        }
        //假定左孩子最大
        int max=leftChild;
        //判断左右孩纸大的
        if(rightChild<len&&a[rightChild]>a[leftChild]){
            max=rightChild;
        }
        //如果根节点大于左右孩纸，直接返回
        if(a[root]>=a[max]){
            return;
        }
        //否则根节点和左右孩纸中大的交换
        swap(a,root,max);
        //继续 进行调整
        adjustHeap1(a,len,max);
    }

    private static void swap(int[] a, int root, int max) {
        int temp=a[root];
        a[root]=a[max];
        a[max]=temp;
    }

}
