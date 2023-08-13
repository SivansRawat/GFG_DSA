//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        
        
        int first=0,second=1;
        
         if (n == 0) return first;
        if (n == 1) return second;
        
        for (int i = 2; i <= n; i++) {
            int sum = (first + second) % 1000000007;
            first = second;
            second = sum;
        }
        
        return second;
        
    }
}