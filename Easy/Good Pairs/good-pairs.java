//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.solve(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    long solve(int arr[], int n)
    {
        // Complete this function
        
        Arrays.sort(arr);
        
        
        long count =0;
        long prev  =0;
        
        
        for(int i=1;i<n;i++){
            
            if(arr[i]!=arr[i-1]){
                count += i;
                prev  = i;
            }
            
            else{
                count+=prev;
            }
        }
        
        
        return count;
        
        
        
    }
}