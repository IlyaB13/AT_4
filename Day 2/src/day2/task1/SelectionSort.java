package day2.task1;
import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] a) {
        for (int min = 0; min < a.length; min++) {
            int first = min;
            for (int j = min + 1; j < a.length; j++) {
                if(a[j] < a[first]) {
                    first = j;
                }
            }
               int p = a[min];
                a[min] = a[first];
                a[first] = p ;
        }
        System.out.println(Arrays.toString(a));
    }

}
