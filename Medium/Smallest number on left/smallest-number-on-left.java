//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        
        // long nums[] = new long[n] ;
        ArrayList<Integer> arr = new ArrayList<>();
        // int count = n-1;
        
        Stack<Integer> stk = new Stack<>();
        
        for(int i=0;i<n;i++){
            
            
            if(stk.size() == 0){
                
                // nums[count] = -1;
                arr.add(-1);
                // count--;
            }
            
            else if((stk.size() > 0) && (stk.peek() < a[i])){
                
                // nums[count] = stk.peek() ;
                
                arr.add(stk.peek());
                // count--;
            }
            
            
            else if((stk.size() > 0) && (stk.peek() >= a[i] )){
                
                while((stk.size() > 0) && (stk.peek() >= a[i])){
                    
                    stk.pop();
                }
                
                
                if(stk.size() == 0){
                    
                    // nums[count] = -1;
                    arr.add(-1);
                    // count--;
                }
                
                else{
                    // nums[count] = stk.peek();
                    arr.add(stk.peek());
                    // count--;
                }
            }
            
            
            stk.push(a[i]);
            // count--;
            
            
        }
        
        return arr;
        
    }
}