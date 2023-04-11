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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        
       String firststr=arr[0]; // getting the first element of the array 

       for(int i=1;i<arr.length;i++){

           while(arr[i].indexOf(firststr)!=0){

               firststr=firststr.substring(0,firststr.length()-1);

           }

       }

       if(firststr.length()==0)

           return "-1";

         

       return firststr;
        
    }
}