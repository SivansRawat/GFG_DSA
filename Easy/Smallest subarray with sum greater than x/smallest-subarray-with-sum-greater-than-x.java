//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            // int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.smallestSubWithSum(a, n, m));
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here 
        int sum = a[0];
        int minCount = Integer.MAX_VALUE;
        int j=1;
        int i=0;
        //Using two pointer approach
        while(j<n){
            sum = sum + a[j];
            while(sum > x)
            {
                //find min 
                minCount = Math.min(minCount, j-i+1);
                sum = sum - a[i];
                i++;
            }
            j++;
        }
        
        if(n==1 && a[0]>x){
            return 1;
        }else if(n==1 && a[0]<=x){
            return 0;
        }
        
        if(minCount==Integer.MAX_VALUE)
            return 0;
            
        return minCount;
    

    }
}

