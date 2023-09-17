//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        //Your code here
        
        
         
        long[] arr = new long[n] ;
        long n1 =1;
        long n2 =1 ;
        long n3;
        long count = n+1;
        ArrayList<Long> arrList = new ArrayList<Long>();
        arrList.add(n1);
        arrList.add(n2);
        for(int i =2 ; i<n ;i++){
            n3 = n1+n2 ;
            arrList.add(n3);
            n1 = n2 ;
            n2 = n3;
        }
        
        for(int i = 0;i<n;i++){
            arr[i] = arrList.get(i);
            
        }
        
        return arr;
    }
}