//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        
        
        long product= 1;
        long maxp = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            
            product *= arr[i];
            
            if(product > maxp){
                maxp = product;
            }
            
            if(product == (long)0 ){
                product=1;
                
            }
        }
        
        product =1;
        
        for(int i=n-1;i>=0;i--){
            
            product *= arr[i];
            
            maxp = Math.max(maxp,product);
            
            // if(product > maxp){
            //     maxp = product;
            // }``
            
            if(product ==(long)0 ){
                product=1;
                
            }
        }
        
        return maxp;
    }
}