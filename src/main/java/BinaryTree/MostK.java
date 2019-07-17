package BinaryTree;

import java.util.Arrays;

//海量数据，如何让在小于O(nlogn)找到100w里面前十大元素
//建小堆
public class MostK {
    public static void main(String[] args) {
       int[] a={1,2,3,4,5,6,7,8,9,10,33,55,777,2,25,64,47,85,58,8,5,9};
       int [] k=new int[5];
       int i=0;
       for(i=0;i<k.length;i++){
           k[i]=a[i];
       }
       buildMinHeap(k,k.length);
       for(int j=k.length;j<a.length;j++){
           //将后面的元素与堆顶元素进行比较，如果小于堆顶元素，往后走，若大于，交换。
           int root=k[0];
           if(a[j]>root){
               k[0]=a[j];
               adjustHeap(k,0,k.length);
           }
       }
       System.out.println(Arrays.toString(k));
    }

    public static void buildMinHeap(int[] K, int length) {
        //以数组来模仿堆，父节点为i=(length-1)/2,左孩子为2i+1,右孩子为2i+2
        for(int i=length/2-1;i>=0;i--) {
            adjustHeap(K,i,length);
        }
    }

   public static void adjustHeap(int[] k, int i, int length) {
        //左孩子
        int left=2*i+1;
        //右孩子
        int right=2*i+2;
        int adjust=i;
        while(true){
            if(left<length&&k[left]<k[adjust]){
                adjust=left;
            }
            if(right<length&&k[right]<k[adjust]){
                adjust=right;
            }
            //若此时i!=adjust证明位置进行调换了
            if(i!=adjust){
                int t=k[adjust];
                k[adjust]=k[i];
                k[i]=t;
            }
            else
                break;
            i=adjust;
            left=2*i+1;
            right=2*i+2;
        }
    }
}
