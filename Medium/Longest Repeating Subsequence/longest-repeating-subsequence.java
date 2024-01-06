//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String s1)
    {
        // code here
        
        int x = s1.length();
        int y  = s1.length();
    
        int ans = lcs(x,y,s1,s1);
        
        return ans ;
      
        
        
    }
    
    
     static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        
        int[][] dp = new int[x+1][y+1];
        
        for(int i=0 ;i<x+1;i++){
            for(int j=0;j<y+1;j++){
                if(i==0 || j==0) dp[i][j] =  dp[i][j] = 0;
            }
        }
        
    
        for(int i=1;i<x+1;i++){
            for(int j=1;j<y+1;j++) {
        
        
        
        if( (i!=j) && s1.charAt(i-1) == s2.charAt(j-1)){
            
           
            dp[i][j] =  1+dp[i-1][j-1];
        }
        
      
        else{
            
            dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
        }
        
        
            }
        }
        
        
        return dp[x][y];
        
    }
}