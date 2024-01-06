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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String S){
        // code here
        
        String reversedStr = "";

        for (int i = 0; i < S.length(); i++) {
            reversedStr = S.charAt(i) + reversedStr;
        }

        int ans = lcs(S.length(), S.length(), S, reversedStr);

        return S.length() - ans;

    }

    static int lcs(int x, int y, String s1, String s2) {
        // your code here

        int[][] dp = new int[x + 1][y + 1];

        for (int i = 0; i < x + 1; i++) {
            for (int j = 0; j < y + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = dp[i][j] = 0;
            }
        }

        for (int i = 1; i < x + 1; i++) {
            for (int j = 1; j < y + 1; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

                else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[x][y];

    }
}