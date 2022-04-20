package sort;

public class BubbleSort {
    /**
     * 这是一个bubble排序
     * @return
     */
    public static int[] bubbleSort(int [] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int tmp;
        for (int i = 0; i <arr.length ; i++) { //执行n次
            for (int j = 0; j <arr.length -1 ; j++) { //执行n-1次
                if  (arr[j] >arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
        return arr;
    }

}
