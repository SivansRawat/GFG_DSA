//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    int longestCommonSubstr(String s1, String s2, int x, int y){
        // code here
        
          int[][] dp = new int[x+1][y+1];
        
       
        
        for(int i=0 ;i<x+1;i++){
            for(int j=0;j<y+1;j++){
                if(i==0 || j==0) dp[i][j] =  dp[i][j] = 0;
            }
        }
        
    
     int maxLength = 0; // Variable to keep track of the maximum length of common substring

        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]); // Update maximum length
                } else {
                    dp[i][j] = 0; // Reset length when characters don't match
                }
            }
        }

        return maxLength;
        
    }
}