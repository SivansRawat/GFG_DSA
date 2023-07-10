//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int A[], int N, int X)
    {
        // code here
        
        Arrays.sort(A);
        int closestSum = A[0] + A[1] + A[2]; // Initialize closest sum with the sum of the first three elements

        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1;
            int k = A.length - 1;

            while (j < k) {
                int sum = A[i] + A[j] + A[k];

                if (Math.abs(X - sum) < Math.abs(X - closestSum)) {
                    closestSum = sum; // Update closest sum if the current sum is closer to the X
                }

                if (sum < X) {
                    j++; // Increment j to increase the sum
                } else {
                    k--; // Decrement k to decrease the sum
                }
            }
        }

        return closestSum;
    }
}