import java.util.*;

public class TwoPointer {

    public void dnfSort(int[] arr){

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while(mid <= high){

            if(arr[mid] == 2){
                // throw the element at higher side
                // i.e. swap arr[mid], arr[high];

                high--;
            } else if(arr[mid] == 1){

                // ignore & increase mid;
                mid++;

            } else{

                // encounter 0, throw to the low side.
                // i.e. swap arr[low], arr[mid];

                low++;
                mid++;
            }
        }
    }

    public void twoPointerOutwards(int[] arr){

        // method used for palindrome check outwards.

        // Note: middle = (n-1)/2

        int firstMiddle = (arr.length - 1)/2;
        // based on length secondMiddle is varied
        int secondMiddle = arr.length %2 == 0 ? firstMiddle + 1 : firstMiddle;

        while(firstMiddle >= 0 && secondMiddle < arr.length){

            //do something

            //go outwards
            firstMiddle--;
            secondMiddle++;
        }
    }

    public void twoPointerInwards(int[] arr){
        //method used for palindrome check, reverse etc.

        int low = 0;
        int high = arr.length -1;

        while(low <= high){

            // reverse -> swap
            // palindrome: (arr[low] != arr[high]) -> break;

            //move closer
            low++;
            high--;
        }
    }

    public void twoPointerWithDuplicates(int[] arr, int target){

        //make sure array is sorted.
        //Here array having duplicates.

        int low = 0;
        int high = arr.length-1;

        while(low < high){
            // since it's a comparisions we have =,>,<
            if(arr[low] + arr[high] == target){

                //do something

                //incrementing low value, by skipping duplicates
                while(arr[low+1] == arr[low]){
                    low++;
                }
                low++;

                //incrementing high value, by skipping duplicates
                while(arr[high-1] == arr[high]){
                    high--;
                }
                high--;
            } else if(arr[low] + arr[high] < target){

                // increase L.H.S, by skipping duplicates
                while(arr[low+1] == arr[low]){
                    low++;
                }
                low++;
            } else{

                // decrease R.H.S. by skipping duplicates
                while(arr[high-1] == arr[high]){
                    high--;
                }
                high--;
            }
        }
    }


    public void twoPointerWithoutDuplicates(int[] arr, int target){

        // make sure the array is sorted,

        // assuming array doesn't have duplicates.

        int low = 0;
        int high = arr.length-1;

        while(low < high){

            // since it's a comparision we have =, <, >
            if(arr[low] + arr[high] == target){

                //do something
                //return true;

                //move closer
                low++;
                high--;
            } else if(arr[low] + arr[high] < target){

                // increase LHS. i.e.
                low++;
            } else{

                // decrease RHS. i.e.
                high--;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[] {9,8,3,2,5,6,1};
        Arrays.sort(arr);

        //two pointer algorithm to find a particular target
    }
}
