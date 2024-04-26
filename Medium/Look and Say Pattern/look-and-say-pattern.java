//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String lookandsay(int n) {
        if(n==1) return "1";
        String prev="11";
        String ans="";
        for(int i=2;i<n;i++){
            int count=0,j=0;
            int currDigit=prev.charAt(0);
            while(j<prev.length()){
                if(currDigit==prev.charAt(j)){
                    count++;
                }
                else{
                    ans+=String.valueOf(count);
                    ans+=prev.charAt(j-1);
                    currDigit=prev.charAt(j);
                    count=1;
                }
                j++;
            }
            ans+=String.valueOf(count);
            ans+=prev.charAt(prev.length()-1);
            prev=ans;
            ans="";
        }
        return prev;
    }
}