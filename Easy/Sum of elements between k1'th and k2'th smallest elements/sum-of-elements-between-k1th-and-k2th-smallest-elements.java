//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            StringTokenizer stt = new StringTokenizer(br.readLine());
            long k1 = Long.parseLong(stt.nextToken());
            long k2 = Long.parseLong(stt.nextToken());
            
            Solution obj = new Solution();
            System.out.println( obj.sumBetweenTwoKth(a, n, k1, k2) );
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution { 
    public static long sumBetweenTwoKth(long a[], long n, long k1, long k2)
    {
        // Your code goes here
        
        
                // Max heap as we want to eliminate elements that are large
        PriorityQueue<Long> pq = new PriorityQueue<>((a1, b) -> b.compareTo(a1));

 
        for (long i = 0; i < n; i++) {
            pq.add(a[(int) i]);
            if (pq.size() > k2) {
                pq.poll();
            }
        }

    
        long ans = 0;
        pq.poll();
        while (pq.size() > k1) {
            ans += pq.poll();
        }
        return ans;
    }
    
}
