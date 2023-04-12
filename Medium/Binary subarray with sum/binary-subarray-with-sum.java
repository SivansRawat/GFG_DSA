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
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int arr[], int N, int target){
        // code here
        
        int curSum =0;
        int start = 0;
        int end = -1;
        int max =0; 
        int count = 0 ;
        
        
        // Solution using HashMap  but this question is of Variable Sliding Window 
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        
        for(int i =0;i<N;i++){
            
            curSum += arr[i];
            
            map.put(curSum , map.getOrDefault(curSum , 0) +1);
            
            
            
            if((curSum - target) ==0 ){
                // max = Math.max(max,i+1);
                count+=1;
                
            
            }
            
            
            if(map.containsKey(curSum-target)){
                
                // max = Math.max(max,i-map.get(curSum-K));
                count+=map.get(curSum-target);
    
            }
            
            // if(!map.containsKey(curSum)){
            //     map.put(curSum,0);
            // }
            
            
            
            
            
        }
        
        
        return count;
        
        
    }
}