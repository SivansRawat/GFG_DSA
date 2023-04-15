//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxAverage(arr, n, k);
            for(int i=ans; i<ans+k; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxAverage(int[] arr, int n, int k) {
        // code here
        
        // int m = 10005412336548794L;
        int sum = 0, max_sum = 0, start = 0, result = 0;
        for(int i = 0; i<n; i++){
            if(i>=k){
                sum+=arr[i];
                sum-=arr[start++];
                if(sum>max_sum){
                    max_sum = sum;
                    result = start;
                }
            }else{
                sum+=arr[i];
                if(i==k-1) max_sum = sum;
            }
        }
        return result;
    }
}
