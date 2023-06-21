//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);

            Solution ob = new Solution();
            System.out.println(ob.sumOfNaturals(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int sumOfNaturals(int n) {
        // code here
        
        long sum =0;
        
        long ans = 0;
        
        for(long i=0;i<=n;i++){
            
            sum = sum+i;
            
            ans = sum % (1000000007);
        }
        
        
        return (int) ans ;
        
    }
};