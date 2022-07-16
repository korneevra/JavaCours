import java.util.Arrays;

// Алгоритм сортировки массива слиянием половинок

public class lesson3_1 {

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 6, 5, 2, 4, 3, 9};
        System.out.println(Arrays.toString(sort(arr)));
    }
    public static int[] sort(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr;
        int[] left = sort(Arrays.copyOfRange(arr, 0, n/2));
        int[] right = sort(Arrays.copyOfRange(arr, n/2, n));
        int ln = left.length;
        int rn = right.length;
        int[] res = new int[n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < ln && j < rn) {
            if (left[i] <= right[j]) {
                res[k] = left[i];
                i++;
                k++;
            } else {
                res[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < ln) {
            res[k] = left[i];
            i++;
            k++;
        }
        while (j < rn) {
            res[k] = right[j];
            j++;
            k++;
        }
        return res;


    }
}
