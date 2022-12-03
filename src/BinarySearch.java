import java.util.*;

public class BinarySearch {

    public double sqrt(int num){

        double low = 1;
        double high = num;
        double eps = 1e-7;

        // decreasing the region to get convergence
        while(eps < (high - low)){

            double mid = (low + high)/2.0;

            // ideally mid*mid == num may not be possible.
            if(mid*mid < num){
                low = mid;
                // low = mid + 1e-15 least increased number.
            } else{
                high = mid;
            }
        }

        return low;
    }

    public int rotatedSortedArray(int[] arr){
        //see lovebabbar youtube iterative solution

        return -1;
    }

    public int findPeakElement(int[] arr){

        // given a bitonic array
        int low = 0;
        int high = arr.length-1;

        while(low <= high){

            // get the mid element
            int mid = low - (low - high)/2;

            // getting left & right element
            int leftEle = mid - 1 >= 0 ? arr[mid-1] : Integer.MIN_VALUE;
            int rightEle = mid + 1 < arr.length ? arr[mid+1] : Integer.MIN_VALUE;

            // based on leftEle, arr[mid], rightEle there will be only 3 slopes
            // increasing, peakpoint, decreasing slope

            if(leftEle < arr[mid] && arr[mid] < rightEle){

                //increasing slope
                low = mid + 1;
            } else if(leftEle < arr[mid] && arr[mid] > rightEle){

                //peak point
                return mid;
            } else {

                //decreasing slope
                high = mid - 1;
            }

        }

        //if it's bitonic array above binary search will be converged.

        return -1; //ideally this line shouldn't execute.
    }

    public int searchInsertPosition(int[] arr, int ele){

        /**
         * sorted array without duplicates
         * if ele is in array return it's position.
         * if not return where it should be inserted.
         */

        int pos = -1;

        int low = 0;
        int high = arr.length - 1;

        while(low <= high){

            // get the mid element
            int mid = low-(low-high)/2;

            // comparing arr[mid] with element
            // <,>,=

            if(arr[mid] < ele){

                pos = mid;

                //move to higher region
                low = mid+1;
            } else if(arr[mid] > ele){
                //move to lower region
                high = mid-1;
            } else{

                return mid;
            }
        }

        return pos+1;
    }

    public int searchLastPos(int[] arr, int target){

        int pos = arr.length;

        int low = 0;
        int high = arr.length-1;

        while(low <= high){

            // pick the middle one
            int mid = low - (low-high)/2;

            // 3 comparisions <,>,=
            if(arr[mid] < target){
                // move to the higher region
                low = mid+1;
            } else if (arr[mid] > target) {
                // move to the lower region
                high = mid - 1;
            } else{
                pos = mid;
                // move to the higher region
                low = low + 1;
            }
        }

        return pos;
    }

    public int searchFirstPos(int[] arr, int target){

        int pos = -1;

        int low = 0;
        int high = arr.length-1;

        while(low <= high){

            // pick the middle one
            int mid = low - (low-high)/2;

            // 3 comparisions <,>,=
            if(arr[mid] < target){
                // move to the higher region
                low = mid+1;
            } else if (arr[mid] > target) {
                // move to the lower region
                high = mid - 1;
            } else{
                pos = mid;
                // move to the lower region
                high = mid - 1;
            }
        }

        return pos;
    }

    public int binarySearch(int[] arr, int target){

        int low = 0;
        int high = arr.length-1;

        while(low <= high){

            // pick the middle one.
            int mid = low - (low-high)/2;

            // since we are comparing arr elements with target.
            // we have <,>,=

            if(arr[mid] < target){
                //move to higher region
                low = mid+1;
            } else if(arr[mid] > target){
                //move to lower region
                high = mid-1;
            } else{
                return mid;
            }
        }

        // unable to get the target
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9,8,3,2,5,6,1};
        Arrays.sort(arr);
    }
}
