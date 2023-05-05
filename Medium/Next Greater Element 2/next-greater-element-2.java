//{ Driver Code Starts
// Initial Template for Java

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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans[] = obj.nextGreaterElement(n, a);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int[] nextGreaterElement(int N, int arr[]) {
        // code here
        
        // int[] nums = new int[N];
        
        // int [] nums1 = new int[N];
        
        // int count = N-1;
        
        // int count1 = 0;
        
        // Stack<Integer> stk = new Stack<>();
        
        // Stack <Integer> stk1 = new Stack<>();
        
        
        
        // for(int i=N-1;i>=0;i--){
            
            
        //     if(stk.size() == 0){
                
        //         nums[count] = -1;
        //         // count--;
        //     }
            
        //     else if((stk.size() > 0) && (stk.peek() > arr[i])){
                
        //         nums[count] = stk.peek() ;
        //         // count--;
        //     }
            
            
        //     else if((stk.size() > 0) && (stk.peek() <= arr[i] )){
                
        //         while((stk.size() > 0) && (stk.peek() <= arr[i])){
                    
        //             stk.pop();
        //         }
                
                
        //         if(stk.size() == 0){
                    
        //             nums[count] = -1;
        //             // count--;
        //         }
                
        //         else{
        //             nums[count] = stk.peek();
        //             // count--;
        //         }
        //     }
            
            
        //     stk.push(arr[i]);
        //     count--;
            
            
        // }
        
        
        
        // // for(int i=0;i<N;i++){
            
            
        // //     if(stk1.size() == 0){
                
        // //         nums1[count1] = -1;
        // //         // count--;
        // //     }
            
        // //     else if((stk1.size() > 0) && (stk1.peek() > arr[i])){
                
        // //         nums1[count1] = stk1.peek() ;
        // //         // count--;
        // //     }
            
            
        // //     else if((stk1.size() > 0) && (stk1.peek() <= arr[i] )){
                
        // //         while((stk1.size() > 0) && (stk1.peek() <= arr[i])){
                    
        // //             stk1.pop();
        // //         }
                
                
        // //         if(stk1.size() == 0){
                    
        // //             nums1[count1] = -1;
        // //             // count--;
        // //         }
                
        // //         else{
        // //             nums1[count1] = stk1.peek();
        // //             // count--;
        // //         }
        // //     }
            
            
        // //     stk1.push(arr[i]);
        // //     count1++;
            
            
        // // }
        
        // //   1 2 3 4 5    5 1 2 3 4
        
        
        
        
        // // for(int i=0;i<N;i++){
            
        // //     if((nums[i] == -1  ) && nums1[i] != -1){
        // //         nums[i] = nums1[i];
        // //     }
        // // }
        
        
        
        // // return nums;
        
        
        // for(int i=0)
        
        // public static long[] nextLargerElement(long[] arr, int n) { 
    // int nums[] = new int[N];
    // int count = N-1;
    // Stack<Integer> stk = new Stack<>();

    // // First traversal
    // for (int i = 2*N-1; i >= 0; i--) {  //   4 3 2 1 0   1 0  2 1 0 
    //     int j = i % N;

    //     while (!stk.isEmpty() && stk.peek() <= arr[j]) {
    //         stk.pop();
    //     }

    //     nums[j] = (stk.isEmpty() ? -1 : stk.peek());
    //     stk.push(arr[j]);
    // }

    // // Second traversal
    // for (int i = N-1; i >= 0; i--) {
    //     if (nums[i] == -1) {
    //         while (!stk.isEmpty() && stk.peek() <= arr[i]) {
    //             stk.pop();
    //         }

    //         nums[i] = (stk.isEmpty() ? -1 : stk.peek());
    //     }
    // }

    // return nums;
    
    
    
    Stack<Integer> st = new Stack<>();
    int[] ans = new int[N];
    
    for (int i = N- 1; i >= 0; i--) {
        st.push(arr[i]);
    }
    for (int i = N - 1; i >= 0; i--) {
        while (!st.empty() && st.peek() <= arr[i]) {
            st.pop();
        }
        if (st.size() == 0) {
            ans[i] = -1;
        } else {
            ans[i] = st.peek();
        }
        st.push(arr[i]);
    }
    return ans;
}

        
        
        
        
        
    }
