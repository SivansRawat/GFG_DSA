//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
public long MergeAndCount(long[] arr, long[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;
        long inversionCount = 0;
        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount += (mid - i);
            }
        }
        while (i <= mid - 1) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        return inversionCount;
    }

    public long MergeSortAndCount(long[] arr, long[] temp, int left, int right) {
        long inversionCount = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            inversionCount += MergeSortAndCount(arr, temp, left, mid);
            inversionCount += MergeSortAndCount(arr, temp, mid + 1, right);
            inversionCount += MergeAndCount(arr, temp, left, mid + 1, right);
        }
        return inversionCount;
    }

    public long inversionCount(long[] arr, long N) {
        long[] temp = new long[(int) N];
        return MergeSortAndCount(arr, temp, 0, (int) (N - 1));
    }
}