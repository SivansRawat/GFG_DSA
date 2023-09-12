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
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isPerfectNumber(long N) {
        // code here
        
        long count = 1;
        if(N ==1){
            return 0;
        }

        for(int i=2 ; i<=Math.sqrt(N); i++){
            if(N%i==0){
                count +=i+N/i;
            }
        }
        
        if( count == N) return 1;
        else{
            return 0;
        }
    }
};