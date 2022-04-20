package sort;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertSort {
    public final Logger log = LoggerFactory.getLogger(getClass());

    public int[] insertSort(int[] arrs){
        if (arrs.length == 0) {
            return arrs;
        }
        for (int i = 1; i < arrs.length; i++) {
            if (arrs[i] < arrs[i-1]) {
                int num = arrs[i];
                int index = i;
                for (int j = i-1; j >0&& num<arrs[j] ; j--) {
                    arrs[index] = arrs[j];
                    arrs[j] = num;
                    index = j;
                }
            }

        }
        return arrs;
    }
}
