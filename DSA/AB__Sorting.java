package DSA;

import java.util.Arrays;

public class AB__Sorting {
    public static void main(String[] args) {
        int[] arr = {5,4,2,6,1,3};
        cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void insertion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static void selection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int start = 0;
            int end = arr.length - 1 - i;
            int max = greatest(arr, start, end);
            swap(arr, max, end);
        }
    }

    public static int greatest(int[] arr, int start, int end) {
        int max = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }
    public static void cyclic(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int correct = arr[i] - 1;
            swap(arr, i, correct);
        }
    }
}
