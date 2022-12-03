import java.util.*;

public class SlidingWindow {

    public int maxSumForConsecutiveK(int[] arr, int k){

        //creating a window [0,k-1]

        //i.e. summation [0,k-1];
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum += arr[i];
        }

        int maxSum = sum;

        // getting the max value at every slide
        // frontPointer arr[i] & backPointer arr[i-k];

        for(int i = k; i<arr.length; i++){
            sum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum,sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        // algo:

        int n = 10;
        int[] arr = new int[n];

        //creating a window, size = k
        int k = 4;

        int sum = 0;
        for(int i = 0; i<k; i++){

            //do something
            sum += arr[i];
        }

        //(sliding)moving the window to right
        // i.e. adding frontPointer = arr[i] &
        // removing backPointer = arr[i-k]

        for(int i = k; i < n; i++){

            sum += arr[i] - arr[i-k];
            //do something
        }

    }
}
