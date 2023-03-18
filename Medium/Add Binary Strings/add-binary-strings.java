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
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        // code here
        
        StringBuilder res = new StringBuilder();
        int i = A.length() - 1, j = B.length() - 1;
        int sum, carry = 0;
        while (i >= 0 || j >= 0 || carry ==1) {
            sum = carry;
            if (i >= 0) sum += A.charAt(i--) - '0';
            if (j >= 0) sum += B.charAt(j--) - '0';
            res.append((char)(sum % 2 + '0'));
            carry = sum / 2;
        }
        if (carry != 0) res.append('1');
        
    //     while (res.length() > 1 && res.charAt(0) == '0') {
    // res.deleteCharAt(0);
    //     }
    
    for (int m = res.length() - 1; m >= 0; m--) {
    if (res.charAt(m) == '0') {
        res.deleteCharAt(m);
    } else {
        break;
    }
}

        return res.reverse().toString();
        
        
        
    }
}