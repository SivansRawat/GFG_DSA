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
            
            System.out.println(new Solution().findNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findNum(int n)
    {
        // Complete this function
        
        int ans =0;
        
        int i=0;
        
        while(i<n){
            
            ans++;
            
            int j = ans;
            
            while(j!= 0){
                
                if(j%5!=0) break;
                
                
                
                else i++;
                j=j/5;
            }
        }
        
        
        return ans;
    }
}