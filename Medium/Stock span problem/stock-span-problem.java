//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int _first,int _second){
        this.first=_first;
        this.second=_second;
    }
}

class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        
        int nums[] = new int[n] ;
        int count = 0;
        
        Stack<Pair> stk = new Stack<>();
        
        for(int i=0;i<n;i++){
            
            
            if(stk.size() == 0){
                
                nums[count] = -1;
                // count--;
            }
            
            else if((stk.size() > 0) && (stk.peek().first > price[i])){
                
                nums[count] = stk.peek().second ;
                // count--;
            }
            
            
            else if((stk.size() > 0) && (stk.peek().first <= price[i] )){
                
                while((stk.size() > 0) && (stk.peek().first <= price[i])){
                    
                    stk.pop();
                }
                
                
                if(stk.size() == 0){
                    
                    nums[count] = -1;
                    // count--;
                }
                
                else{
                    nums[count] = stk.peek().second;
                    // count--;
                }
            }
            
            
            stk.push(new Pair(price[i],i));
            count++;
            
        }
        
        
        for(int i=0;i<n;i++){
        
            nums[i] = i-nums[i];
        }
        
        
        return nums;
        
    }
    
}