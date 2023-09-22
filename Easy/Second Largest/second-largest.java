//{ Driver Code Starts
//Initial Template for Java



import java.util.stream.Collectors; 
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        // code here
             // Initialize result variable to store second largest    
        int res = 0;
         // Initialize largest variable to store the largest number in the array
        int largest = -1;
        
        for(int i =0;i<n;i++){
             // Initialize largest variable to store the largest encountered so far
            if(arr[i]>largest){
                res = largest;  // Update res to store the previous largest (now second largest
                largest = arr[i];  // Update largest to store the new largest value
            }else if (arr[i] !=largest){
                if(res == -1 || arr[i]>res){  // Check if res is uninitialized (-1) or if the current element is greater than res
                    res = arr[i]; // Update res to store the current element as the new second largest
                }
            }
            
        }
        
        return res;
    }
}