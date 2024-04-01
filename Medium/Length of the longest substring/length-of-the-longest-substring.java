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
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        int max = Integer.MIN_VALUE,r=0;

        ArrayList<Character>arr = new ArrayList();

        while(r<S.length()){

            if(!arr.contains(S.charAt(r))){

                arr.add(S.charAt(r));

                r++;

            }

            else{

                max = Math.max(max,arr.size());

                arr.remove(0);

            }

        }

        max = Math.max(max,arr.size());

        return max;
        
        

    }
}