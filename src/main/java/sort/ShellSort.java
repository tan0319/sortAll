package sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static int[] shellSort(int[] arrs){
        int arrLenth = arrs.length;
        if(arrLenth == 0){
            return arrs;
        }
        //初始分组
        int gap = arrLenth/2;
        int tmp;
        int count = 1;
        while(gap >=1 ){
            for (int j = gap; j < arrLenth ; j++) {
                int index = j;
                while(index -gap >=0 && arrs[index-gap] > arrs[index]){
                    if (arrs[index-gap] > arrs[index]){
                        tmp = arrs[index-gap];
                        arrs[index-gap] = arrs[index];
                        arrs[index] = tmp;
                    }
                    index -= gap;
                }
            }
            gap /= 2;//获取新的增量
            System.out.println("第"+ count +"次：   " + Arrays.toString(arrs));
            count ++;
        }
        return arrs;
    }
}
