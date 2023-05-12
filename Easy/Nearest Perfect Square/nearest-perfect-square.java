//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans[] = ob.nearestPerfectSquare(N);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] nearestPerfectSquare(int N) {
        // code here
         double val=Math.sqrt(N);
       int value=(int)val;
       int ans[]=new int[2];
       if(value==val)
       {
           ans[0]=N;
           ans[1]=0;
       }
       else if(val>value)
       {
           int extra=value+1;
           int one=value*value;
           int two=extra*extra;
           if(Math.abs(N-one)<Math.abs(N-two))
           {
               ans[0]=one;
               ans[1]=Math.abs(N-one);
           }
           else
           {
               ans[0]=two;
               ans[1]=Math.abs(N-two);
           }
       }
       return ans;
        
    }
}