//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

    
class Solution {
    
    int[][] dp;

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int palindromicPartition(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return palindromicPartitionHelper(s, 0, n - 1);
    }

    private int palindromicPartitionHelper(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minCuts = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) {
                minCuts = Math.min(minCuts, 1 + palindromicPartitionHelper(s, k + 1, j));
            }
        }

        return dp[i][j] = minCuts;
    }
}