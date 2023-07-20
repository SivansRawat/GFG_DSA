//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    
	    int min_num = Integer.MAX_VALUE;
	    int total =0;
	    
	    for(int num : arr){
	        total+=num;
	    }
	    
	    
	    boolean[] number_list = subsetSum(n,total,arr);
	    
	    for(int i =0 ; i < number_list.length;i++){
	        
	        if(number_list[i]){
	            
	            min_num = Math.min(min_num,total-(i*2));
	        }
	    }
	    
	    
	    return min_num;
	    
	} 
	
	
	
	
	public static boolean[] subsetSum( int n,int k,int[]arr){
	    
	    boolean [][] dp = new boolean[n+1][k+1];
	    
	    for(int i=0;i<n+1;i++){
	        
	        dp[i][0] = true;
	    }
	    
	    
	    
	    for(int i =1;i<n+1;i++){
	        
	        for(int j=1;j<k+1;j++){
	            
	            if(arr[i-1] <= j){
	                
	                dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
	            }
	            
	            else{
	                
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    
	    
	    return Arrays.copyOfRange(dp[n],0,(k/2)+1);
	    
	    
	}
}
