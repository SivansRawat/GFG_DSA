//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  
  public static List<String> generateBinaryStrings(int n) {
    // code here
        ArrayList<String> arr=new ArrayList<>();
        fun(n, 0, "" , arr);
        return arr;
  }
  
  public static void fun(int n , int lastPlace , String str , ArrayList<String> arr){
     
        if(n==0){
            arr.add(str);
            return;
        }
        if(lastPlace==0){
            fun(n-1, 0, str+"0" , arr);
            fun(n-1, 1, str+"1" , arr);
        }else{
            fun(n-1, 0, str+"0" , arr);
        }
  }
  
  
}