package sort;

public class SelectSort {

    public static int[] selectSort(int [] arr) {
        if (arr.length ==0) {
            return arr;
        }
        for (int i = 0; i <arr.length ; i++) {
            int min = arr[i];
            int minIndex = i;
            int tmp;
            for (int j = i; j < arr.length-1; j++) {
                if (arr[j+1] < min) {
                    min = arr[j+1];
                    minIndex = j+1;
                }
            }
            tmp = arr[i];
            arr[i] = min;
            arr[minIndex] = tmp;
        }
        return arr;
    }
}
