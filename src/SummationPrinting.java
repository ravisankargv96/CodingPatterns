import java.util.*;

public class SummationPrinting {
    public static void main(String[] args) {

        // k = 0 -> n Summation  a(k)
        // value += a[0]
        // extend this to a[1],a[2],....

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};

        int value = 0;
        for(int i = 0; i< arr.length; i++){
            value += arr[i];
        }


        // for power calculation linearly
        // a*r^k;
        // r = 2;
        // a = 10;

        // val *= r
        // repeat the above for k times;
        // later multiply by a
        //i.e.

        int a = 10;
        int r = 2;

        int val = 1;
        for(int i = 0; i < 10; i++){
            val *= r;
        }

        val = val*a;

    }
}
