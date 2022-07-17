import java.util.Arrays;

public class lesson3_2 {

    // Реализовать алгоритм пирамидальной сортировки (HeapSort)

    public static void heapSort(int[] arr, int len, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < len && arr[left] > arr[max]) {
            max = left;
        }
        if (right < len && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapSort(arr, len, max);
        }
    }

    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 16, 6, 19, 2, 65, 89, 4, 16, 78, 24, 15, 18, 3, 48};
        int len = arr.length;

        for (int i = len / 2 - 1; i >= 0 ; i--) {
            heapSort(arr, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSort(arr, i, 0);
        }
        System.out.println(Arrays.toString(arr));

    }
}
