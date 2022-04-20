package sort;

import java.util.Arrays;

public class FastSort {

    public static int[] fastSort(int[] arrs,int low,int high) {
        if(low < high) {
            int mid = partition(arrs, low, high);
            System.out.println(Arrays.toString(arrs));
            fastSort(arrs, low,mid-1);
            fastSort(arrs, mid+1, high);
        }
        return arrs;
    }

    /**
     * @param arrs 待排序的数组
     * @param low  头指针
     * @param high 尾指针
     * @return
     */
    public static int partition(int[] arrs,int low,int high) {
        int  key = arrs[low];
        while(low < high){
            while (low < high && arrs[high] > key) {
                high --;
            }
            //更换
            swap(arrs, low, high);
            while (low < high && arrs[low] < key){
                low ++;
            }
            swap(arrs,low,high);
        }
        return low;
    }

    /**
     * 交换指针所在元素和基准数
     * @param arrs
     * @param low
     * @param high
     */
    private static void swap(int[] arrs, int low, int high) {
        int tmp = arrs[low];
        arrs[low] = arrs[high];
        arrs[high] = tmp;
    }
}
