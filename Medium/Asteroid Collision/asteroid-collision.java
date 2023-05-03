//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        
        Stack<Integer> stk = new Stack<>();
        
        for(int val: asteroids){
            
            if(val>0){
                stk.push(val);
            }
            
            
            else{
                
                while(stk.size()>0 && stk.peek() >0 && stk.peek()<-val){
                    stk.pop();
                }
                
                
                if(stk.size()>0 && stk.peek()==-val){
                    
                    stk.pop();
                }
                
                
                else if(stk.size()>0 && stk.peek()>-val){
                    
                }
                
                
                else {
                    stk.push(val);
                }
          }


        }
        
        
        int[] ans = new int[stk.size()];
        int i   = ans.length-1;
        while(i>=0){
            ans[i--] = stk.pop();
            
        }
        
        
        return ans ;
        
        
        
        
        
        
    }
}
