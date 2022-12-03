public class Sorting {

    /** Insertion sort
     * */
    public int insertionStep(int[] arr,int prev, int key){

        int j = prev;

        // value > key, move to the right place.
        while( j >= 0 && arr[j] > key){

            //move to right place.
            arr[j+1] = arr[j];
            j--;
        }

        // we'll stop at value lower than key
        // j+1 is also got copied in j+2 position from the above algo.
        return j+1;
    }

    public void insertionSort(int[] arr){

        for(int i = 1; i<arr.length; i++){

            //standing at >1st element
            int key = arr[i];

            //iterate over [0,i-1]
            int pos = insertionStep(arr,i-1,key);

            arr[pos] = key;
        }
    }

    /** Merge sort
     * */
    public void merging(int[] arr, int low, int mid, int high){

        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;

        int k = 0;

        while(i <= mid && j <= high){

            //lower value is added to temp array
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            } else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        //copy the left over values.

        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }

        while(j <= high){
            temp[k] = arr[j];
            j++;
            k++;
        }

        // overright arr[low, high] with the temp values
        for(k = 0; k<temp.length; k++){
            arr[low+k] = temp[k];
        }

    }

    public void mergeSort(int[] arr,int low, int high){
        if(low >= high){
            //i.e ms(int[],0,0) -> terminate this case.
            return;
        }

        int mid = low - (low - high)/2;

        //left branch ms(int[],0,5);
        mergeSort(arr,low,mid);

        //right branch ms(int[],6,10);
        mergeSort(arr,mid+1,high);

        //MergingStep
        merging(arr,low,mid,high);
    }

    /** Quick Sort
     * */
    public void swap(int[] arr, int i, int j){
        int copy = arr[i];
        arr[i] = arr[j];
        arr[j] = copy;
    }

    public void quickSort(int[] arr,int low, int high){

        int i = low;
        int j = high;

        int pivot = arr[low - (low - high)/2];

        // left Elements < pivot && pivot < right Element
        while(i <= j){

            // ignore elements less than pivot
            while(arr[i] < pivot){
                i++;
            }

            // ignore elements greater than pivot
            while(arr[j] > pivot){
                j--;
            }

            if(i <= j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }

        if(low < j){
            quickSort(arr,low,j);
        }

        if(i < high){
            quickSort(arr,i,high);
        }

    }
    public static void main(String[] args) {

    }
}
