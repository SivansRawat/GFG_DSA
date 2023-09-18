//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int n, int matrix[][])
    {
        // code here
        
        int paths[][] = new int[n][n];
        
        for (int col = 0; col < n; col++)
            paths[0][col] = matrix[0][col];
        
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int maxTop = 0;
                for (int i = -1; i <= 1; i++) {
                    if (col + i < 0 || col + i > n - 1) {
                        continue;
                    }
                        
                    maxTop = Math.max(maxTop, paths[row - 1][col + i]);
                }
                
                paths[row][col] = maxTop + matrix[row][col];
            }
        }
        
        int maxPath = 0;
        for (int col = 0; col < n; col++) {
            maxPath = Math.max(maxPath, paths[n - 1][col]);
        }
            
        return maxPath;
    }
}