package sort;

import org.junit.Test;

import java.util.Arrays;

import static sort.BubbleSort.bubbleSort;
import static sort.FastSort.fastSort;
import static sort.HeapSort.heapSort;
import static sort.MergeSort.mergeSort;
import static sort.SelectSort.selectSort;
import static sort.ShellSort.shellSort;

public class test1 {
    @Test
    public void testHeapSort() {
        int[] arrs = {9, 6, 18, 7, 15, 10, 4, 3,};
//        int[] arrs = {9,6};
        System.out.println("待排序：" + Arrays.toString(arrs));
        heapSort(arrs);
    }

    @Test
    public void testMergeSort() {
        int[] arrs = {9, 6, 18, 7, 15, 10, 4, 3,};
//        int[] arrs = {9,6};
        System.out.println("待排序：" + Arrays.toString(arrs));
        int[] mergeSortArr = mergeSort(arrs,0, arrs.length-1);
        System.out.println("快速排序：" + Arrays.toString(mergeSortArr));
    }

    @Test
    public void testFastSort() {
        int[] arrs = {6, 9, 18, 7, 10, 15, 3, 4, 2, 1};
        System.out.println("待排序：" + Arrays.toString(arrs));
        int[] fastSortArr = fastSort(arrs, 0, arrs.length-1);
        System.out.println("快速排序：" + Arrays.toString(fastSortArr));
    }

    @Test
    public void testBubbleSort() {
        int [] arrs = {10, 9, 18, 7, 6, 15, 4, 3, 2, 1};
        System.out.println("待排序：" + Arrays.toString(arrs));
        int[] bubbleSortArr = bubbleSort(arrs);
        System.out.println("冒泡排序：" + Arrays.toString(bubbleSortArr));
    }
    @Test
    public void testSelectSort() {
        int [] arrs = {10, 9, 18, 7, 6, 15, 4, 3, 2, 1};
        System.out.println("待排序：" + Arrays.toString(arrs));
        int[] bubbleSortArr = selectSort(arrs);
        System.out.println("冒泡排序：" + Arrays.toString(bubbleSortArr));
    }
    @Test
    public void testInsertSort() {
        int [] arrs = {10, 9, 18, 7, 6, 15, 4, 3, 2, 1, 100, };
        System.out.println("待排序：" + Arrays.toString(arrs));
        int[] insertSortArr = selectSort(arrs);
        System.out.println("插入排序：" + Arrays.toString(insertSortArr));
    }
    @Test
    public void testShellSort() {
        int [] arrs = {10, 9, 18, 7, 6, 15, 4, 3, 2, 1, 100, };
        System.out.println("待排序：" + Arrays.toString(arrs));
        int[] shellSortArr = shellSort(arrs);
        System.out.println("希尔排序：" + Arrays.toString(shellSortArr));
    }
}
