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
            String s = read.readLine();
            
            Solution ob = new Solution();
            String result = ob.removeDups(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String removeDups(String S) {
        
        // code here
        
        Set<Character> s = new LinkedHashSet<>();
        
        for(int i=0;i<S.length();i++){
            
            s.add(S.charAt(i));
        }
        
        
        StringBuffer sb = new StringBuffer();
        
        for(Character ss : s){
            
            sb.append(ss);
        }
        
        
        return sb.toString();
           
            
    }
}