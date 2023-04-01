//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minOperations(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minOperations(int N) {
        // Code here
        
        // long m = 10005412336548794L;
        // if(N%2==0){  // for array of odd length 
        //     return (long)Math.pow(N/2 ,2);
        // }
        
        // else{
        //     int d = (N)/2;
        //     return (long) d*(d+1) ;
        
        
        int mid=N/2;
        return N%2==0?(long)mid*(long)mid:(long)mid*(long)(mid+1);
        
    }
}