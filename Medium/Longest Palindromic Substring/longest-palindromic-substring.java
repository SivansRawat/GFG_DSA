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
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestPalindrome(String S){
        
        
        // code here
        String str = S.substring(0,1);
        
    if (S == null || S.length() < 1) return "";
    int max = 1;
    int start = 0, end = 0;
    for (int i = 0; i < S.length(); i++) {
        int len1 = expandFromCenter(S, i, i);
        int len2 = expandFromCenter(S, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
        
        if(len > max){
            str = S.substring(start,end+1);
            max = len;
        }
    }
    return str;
}

private static int expandFromCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

}