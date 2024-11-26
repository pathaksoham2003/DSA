package DSA;
public class AA__Search {
    public static void main(String[] args) {
        int[] ar = {1, 2, 5, 4, 3, 6, 12};
        System.out.println(linear(ar, 5));
        int[] arr = {6,5,4,3,2,1};
        System.out.println(Agobin(arr,5));

    }//LINEAR SEARCH:-
    public static int linear(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }//AGNOSTIC BINARY SEARCH:-
    public static int Agobin(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[start] < arr[end]) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
            return -1;
        }
}