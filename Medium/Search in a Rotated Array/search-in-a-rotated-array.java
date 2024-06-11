//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int arr[], int l, int h, int k)
    {
        // l: The starting index
        // h: The ending index, you have to search the key in this range
        // Complete this function
        
        int n = arr.length;
          int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

          
            if (arr[mid] == k)
                return mid;

          
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= k && k <= arr[mid]) {
                   
                    high = mid - 1;
                } else {
                    
                    low = mid + 1;
                }
            } else { 
                if (arr[mid] <= k && k <= arr[high]) {
                    
                    low = mid + 1;
                } else {
                
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}