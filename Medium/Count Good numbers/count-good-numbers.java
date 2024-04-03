//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            long N;
            N = Long.parseLong(br.readLine().trim());

            Solution obj = new Solution();
            int res = obj.countGoodNumbers(N);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countGoodNumbers(long n) {
        // code here
        
        int MOD = 1_000_000_007;
        long result = n%2==0?1:5;
        long x = 20;
        for(long i = n/2;i>0;i/=2){
            if(i%2!=0) result = result*x %MOD;
            x = x*x%MOD;
        } 

        return (int)result;
        
    }
}
