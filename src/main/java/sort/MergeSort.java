package sort;

public class MergeSort {

    //[  0,  1 ]

    public static int[] mergeSort(int[] arrs, int low, int high){
        if (low < high) {
            int mid = (low + high)/2;
            mergeSort(arrs,low,mid);
            mergeSort(arrs,mid+1, high);
            merge(arrs,low,high,mid);
        }
        return arrs;
    }

    public static void merge(int[] arr, int low, int high,int mid) {
        if (low != high) {
            int[] arrTmp = new int[high+1];
            int index = low;
            int start1 = low;
            int start2 = mid+1;
            //归并
            while(start1 <= mid && start2 <= high){
                if (arr[start1] > arr[start2]) {
                    arrTmp[index] = arr[start2];
                    start2 ++;
                }else {
                    arrTmp[index] = arr[start1];
                    start1 ++;
                }
                index ++;
                //判断是否有一个数组比较完毕
                if (start1 > mid) {
                    while(start2<=high) {
                        arrTmp[index] = arr[start2];
                        index ++;
                        start2 ++;
                    }
                    break;
                }
                if (start2 >high){
                    while(start1<=mid) {
                        arrTmp[index] = arr[start1];
                        index ++;
                        start1 ++;
                    }
                    break;
                }
            }
            int count = low;
            for (int i = low; i <high+1 ; i++) {
                arr[i] = arrTmp[count];
                count ++;
            }
        }
    }


}
