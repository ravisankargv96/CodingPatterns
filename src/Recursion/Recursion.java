package Recursion;

import java.util.*;

public class Recursion {
    /** n branches*/

    /** 2 Branches
     * */
    public int LeftRootRight(int n){

        if(n == 1 || n == 0){
            return n;
        }

        // Standing in this node
        // do something
        int left = LeftRootRight(n-1); // left subproblem

        // do something

        int right = LeftRootRight(n-2); // right subproblem
        // do something

        return left + right;
    }

    // sequence -> considering & not considering case : String as parameter
    public void LeftRootRight(String s, int pos, List<String> ans){

        if(pos == 4){
            // adding to ans
            ans.add(new String(s));
        }

        //Standing in this position do something
        // char c = s.charAt(pos);

        LeftRootRight(s + "(", pos+1, ans);

        // do something

        LeftRootRight(s + ")", pos+1, ans);
    }

    // sequence -> considering & not considering case : ArrayList as parameter
    public void LeftRootRight(ArrayList<Character> st, int pos, List<List<Character>> ans){

        if(pos == 4){

            // or we can also use st.clone();
            ans.add(new ArrayList<Character>(st));
        }

        //standing in the root
        st.add('(');
        LeftRootRight(st,pos+1,ans); //(['('],pos+1,ans);
        st.remove(st.size()-1);

        LeftRootRight(st,pos+1,ans); //([],pos+1,ans);
    }

    public void generateParanthesis(String s, int pos, int n, int open, int close,
                                    List<String> ans){

        if(open > n){
            return;
        }

        if(close > open){
            return;
        }

        if(pos == n){
            ans.add(new String(s));
            return;
        }

        generateParanthesis(s + "(", pos + 1, n, open+1, close, ans);

        generateParanthesis(s + ")", pos + 1, n, open, close + 1, ans);
    }
    public void generateParanthesis(ArrayList<Character> s, int pos, int n, int open,
                                    int close, List<ArrayList<Character>> ans){

        if(open > n){
            return;
        }

        if(close > open){
            return;
        }

        if(pos == n){
            ans.add(new ArrayList<>(s));
            return;
        }

        s.add('(');
        generateParanthesis(s, pos + 1, n, open+1, close, ans);
        s.remove(s.size()-1);

        generateParanthesis(s, pos + 1, n, open, close + 1, ans);
    }

    public void subsequence(int[] num, int pos, ArrayList<Integer> temp,
                            ArrayList<ArrayList<Integer>> ans){

        if(pos == num.length){

            ans.add(new ArrayList<>(temp));
            return;
        }

        //considering number
        temp.add(num[pos]);
        subsequence(num,pos+1,temp,ans);
        temp.remove(temp.size()-1);

        // not considering number
        subsequence(num,pos+1,temp,ans);

    }

    public void subsequence(int[] num, int pos, String temp, ArrayList<String> ans){

        if(pos == num.length){

            ans.add(new String(temp));
            return;
        }

        //considering number
        char c = (char)('0' + num[pos]);
        subsequence(num,pos+1,temp + c,ans);


        // not considering number
        subsequence(num,pos+1,temp,ans);

    }


    // conditional based recursion.
    public int binarySearch(int[] arr,int target, int low, int high){
        if(low >= high){
            return -1;
        }

        int mid = low - (low - high)/2;

        if(arr[mid] == target){
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr,target,mid+1,high);
        } else{
            return binarySearch(arr,target,low, mid);
        }
    }

    //directly getting from formulae
    public int power(int base, int exponent){

        if(exponent == 0){
            return 1;
        }

        if(exponent %2 == 0){
            return power(base,exponent/2) * power(base,exponent/2);
        } else{
            return power(base,exponent/2) * power(base,exponent/2) * base;
        }
    }

    public static void main(String[] args) {

    }
}
