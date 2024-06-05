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
    static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr, 0, N - 1);
    }

    private static long mergeSort(long[] arr, long low, long high) {
        long cnt = 0;
        if (low < high) {
            long mid = (low + high) / 2;
            cnt += mergeSort(arr, low, mid);
            cnt += mergeSort(arr, mid + 1, high);
            cnt += merge(arr, low, mid, high);
        }
        return cnt;
    }

    private static long merge(long[] arr, long low, long mid, long high) {
        ArrayList<Long> temp = new ArrayList<>();
        long left = low;
        long right = mid + 1;

        long cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[(int)left] <= arr[(int)right]) {
                temp.add(arr[(int)left]);
                left++;
            } else {
                temp.add(arr[(int)right]);
                cnt += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[(int)left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[(int)right]);
            right++;
        }

        for (long i = low; i <= high; i++) {
            arr[(int)i] = temp.get((int)(i - low));
        }
        
        return cnt;
    }
}
