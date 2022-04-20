package restart;


import java.util.Arrays;

public class FastSort {

    public static void main(String[] args) {
        int[] arrs = {6, 9, 18, 7, 10, 15, 3, 4, 2, 1};
        System.out.println("待排序：" + Arrays.toString(arrs));
        int[] fastSortArr = fastSort(arrs, 0, arrs.length-1);
        System.out.println("快速排序：" + Arrays.toString(fastSortArr));
    }

    public static int[] fastSort(int[] arr, int low, int high){
        if (low < high) {
            int mid = partition(arr, low, high);
            fastSort(arr, low, mid -1);
            fastSort(arr, mid + 1, high);
        }


        return arr;
    }

    /**
     * 返回基准点位置
     * @param arr  待排序矩阵
     * @param low  头指针
     * @param high  尾指针
     * @return
     */
    public static int partition(int[] arr, int low, int high) {
        int key = arr[low];
        while(low < high) {
            if (low < high && arr[high] > key) {
                high --;
            }
            swap(arr, low, high);
            if(low < high && arr[low] < key) {
                low ++;
            }
            swap(arr, low, high);
        }
        return low;
    }

    /**
     *  交换指针与基准点的位置
     * @param arr
     * @param low
     * @param high
     */
    private static void swap(int[] arr, int low, int high) {
        int tmp = arr[high];
        arr[high] = arr[low];
        arr[low] = tmp;
    }


}
