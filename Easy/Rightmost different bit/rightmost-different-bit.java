//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Main{
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		
		//input number of testcases
		int t=sc.nextInt();
		int m,n;
		while(t-->0) {
		    
		    
            Solution obj = new Solution();
            //input m and n
		    m = sc.nextInt();
		    n = sc.nextInt();
		    System.out.println(obj.posOfRightMostDiffBit(m, n));
		}
	}
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
            
        // Your code here        
            if(m==n)
            return -1;
    
        
        StringBuffer s1=new StringBuffer(Integer.toBinaryString(m));
        StringBuffer s2=new StringBuffer(Integer.toBinaryString(n));
         int max=s1.length()>s2.length()?s1.length():s2.length();
        s1.reverse();
        s2.reverse();
        
       if(s2.length()<s1.length()){
           for(int i=s2.length();i<s1.length();i++){
               s2.append('0');
           }
       }
       else if(s1.length()<s2.length()){
           for(int i=s1.length();i<s2.length();i++){
               s1.append('0');
           }
       }
        
        for(int i=0;i<max;i++){
            try{
                if(s1.charAt(i)!=s2.charAt(i)){
                    return ++i;
                }
            }catch(Exception e){
                return ++i;
            }
            
        }
        
        return -1;
    }
}



