package Sort;

import java.util.ArrayList;

/*二路归并排序*/
public class MergeSort {
    public static void merge(int[] array, int left, int right) {
        if (left == right - 1) {
            return;
        }
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        //采取左闭右开
        merge(array, left, mid);
        merge(array, mid, right);
        _merge(array, left, mid, right);
    }

    private static void _merge(int[] array, int left, int mid, int right) {
        int length = right - left;
        int[] extra = new int[length];
        int i = 0;
        int p = left;
        int q = mid;

        while (p < mid && q < right) {
            if (array[p] <= array[q]) {
                extra[i++] = array[p++];
            } else {
                extra[i++] = array[q++];
            }
        }

        while (p < mid) {
            extra[i++] = array[p++];
        }

        while (q < right) {
            extra[i++] = array[q++];
        }

        System.arraycopy(extra, 0, array, left, length);
    }

    public static void main(String[] args) {
        int[] array = {
                3, 9, 4, 2, 7, 6, 5, 3, 5, 8, 1, 4, 9, 7, 3,
                8, 6, 5
        };
        merge(array,0,array.length);
        for(int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }
    }
}
