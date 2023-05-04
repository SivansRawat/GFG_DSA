//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        // code here
        
         int size = S.length();

        if(size == K) return "0";

        int count = 0;

        Stack<Character> st = new Stack();

        while(count < size){

            

            while(K>0 && !st.isEmpty() && st.peek()>S.charAt(count)){

                st.pop();

                K--;

            }

            

            st.push(S.charAt(count));

            count++;

            

        }

        

        //edge case handle -> repeating string 1111

        while(K-->0){

            st.pop();

        }

        

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){

            char cur = st.pop();

            sb.append(cur);

        }

        

        sb.reverse();

        

        while(sb.length()>1 && sb.charAt(0)=='0'){ //remove leading zeroes

            sb.deleteCharAt(0);

        }

        

        return sb.toString();
    }
}