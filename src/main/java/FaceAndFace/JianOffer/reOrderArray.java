package FaceAndFace.JianOffer;
/*
*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
* 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
* 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
/*
*思路：两层循环，当a[j - 1] % 2 == 0 && a[j] % 2 == 1时，交换，在j--继续进行判断
* 有可能交换后原来不成立的地方，现在成立了
*
 */
public class reOrderArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6, 8, 9, 10};
        reOrderArray1(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void reOrderArray1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j - 1] % 2 == 0 && a[j] % 2 == 1) {
                    int temp = 0;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
