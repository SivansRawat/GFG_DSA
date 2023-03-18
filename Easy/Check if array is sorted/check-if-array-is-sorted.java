//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            boolean ans = new Solution().arraySortedOrNot(arr, n);
            System.out.println(ans ? 1 : 0);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        
        // Using Two pointer approach 
        
        boolean bool = true;
        int i =0 ;
        for(int j =1 ;j<=n-1;j++){
            if(arr[j] >= arr[i]){
                bool = true;
                i++;
            }
            
            else{
                bool = false;
                break;
            }
                
        }
        
        return bool;

    }
}