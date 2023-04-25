//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String s) {
        
         if(s.charAt(s.length()-1)=='.'){
            return false;
        }
        String str[]=s.split("\\.");
        if(str.length!=4){
            return false;
        }
        for(String st:str){
            if(st.isEmpty()){
                return false;
            }
            if(Character.isLetter(st.charAt(0))){
                return false;
            }
            else{
                int a=Integer.parseInt(st);
                if(a==0 && st.length()>1 && st.charAt(1)=='0'){
                    return false;
                }
                if(a>0 && a<=255 && st.charAt(0)=='0'){
                    return false;
                }
                if(!(a>=0 && a<=255)){
                    return false;
                }
            }
        }
        return true;
    }
}