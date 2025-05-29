package DSA.DSA;
import java.util.Arrays;
public class AC__RecurSort {
    public static void main(String[] args) {
        int[] ar = {5, 4, 18, 12, 13, 2, 3};
        System.out.println(Arrays.toString(merge(ar)));
        int[] arr = {5, 4, 18, 12, 13, 2, 3};
        mergeInPlace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
        int[] arrr = {5, 4, 18, 12, 13, 2, 3};
        quick(arrr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arrr));
    }
    // MERGE SORT:- This mechanism does not modify the arr but returns us a sorted array. This takes more space due to this functionality.
    public static int[] merge(int[] arr){
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = merge(Arrays.copyOfRange(arr,0,mid));
        int[] right = merge(Arrays.copyOfRange(arr,mid,arr.length));
        return mergemix(left,right);
    }
    public static int[] mergemix(int[] first,int[] second){
        int[] mix = new int[first.length + second.length];
        int i =0;
        int j =0;
        int k =0;
        while(i<first.length && j<second.length){
            if(first[i]>second[j]){
                mix[k]=second[j];
                j++;
                k++;
            }else{
                mix[k]=first[i];
                i++;
                k++;
            }
        }
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }
        return mix;
    }
    // INPLACE MERGE SORT:- This modifies the array to sort it.
    public static void mergeInPlace(int[] arr,int start,int end){
        if(end - start == 1){
            return;
        }
        int mid = start + (end - start)/2;
        mergeInPlace(arr,start,mid);
        mergeInPlace(arr,mid,end);

        merge(arr,start,mid,end);
    }
    public static void merge(int[] arr,int start,int mid,int end){
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
                k++;
            }else{
                mix[k]=arr[j];
                j++;
                k++;
            }
        }
        while(i<mid){
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j<end){
            mix[k]=arr[j];
            j++;
            k++;
        }
        for(int l =0 ; l<mix.length ; l++){
            arr[start + l] = mix[l];
        }
    }
    // QUICK SORT:-(4Pointer&Pivot)Remember to take 4 pointers that are low,high,start and end. & you shall solve the problem like knife through butter.
    public static void quick(int[] arr,int low,int high){
       if(low>=high){
           return;
       }
       int start = low;
       int end = high;
       int pivot=start + (end-start)/2;
       while(arr[start]<arr[pivot]){
           start++;
       }
       while(arr[end]>arr[pivot]){
           end--;
       }
       if(start<=end){
           int temp = arr[start];
           arr[start]=arr[end];
           arr[end]=temp;
           start++;
           end--;
       }
       quick(arr,low,end);
       quick(arr,start,high);
    }
}
