package sort;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr) {
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }

        for (int i = 0; i < arr.length; i++) {
            swap(arr, 0, arr.length - 1 -i);
            adjust(arr, 0, arr.length - 1 - i);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void adjust(int[] arr, int index, int len) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int bigIndex = index;

        if (leftIndex < len && arr[bigIndex] < arr[leftIndex]) {
            bigIndex = leftIndex;
        }

        if (rightIndex < len && arr[bigIndex] < arr[rightIndex]) {
            bigIndex = rightIndex;
        }

        if (bigIndex != index) {
            swap(arr, index, bigIndex);
            adjust(arr, bigIndex, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
