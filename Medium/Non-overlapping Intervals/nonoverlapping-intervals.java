//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int N, int intervals[][]) {
        // code here\\
        
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int res = 0;
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            
            // If the interval is non overlapping 
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            } 
            
            // If the interval is overlapping 
            else {
                res++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
        }
        
        return res;

        
    }
}
