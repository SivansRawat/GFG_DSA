//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static int Solve(int N, int[] piles, int H) {
        // code here
        
         int low = 1 , high = 1_000_000_000;
        
        while(low<high){
            
            int mid = low+(high-low)/2;
            
            if(isPossible(piles,H,mid)){
                
                high = mid;
                
            }
            
            else{
                low=mid+1;
            }
            
        }
            
            return low;
            
        }
        
        
        
        
     public static boolean isPossible(int[] piles, int h ,int k){
            
            int time = 0;
            
            for(int p: piles){
                time+=(p-1)/k +1;
            
            
            if(time > h){
                
                break;
            }
                
            }
            
            return time<=h;
        }
    
}
        
