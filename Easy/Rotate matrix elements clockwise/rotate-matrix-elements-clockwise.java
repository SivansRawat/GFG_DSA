//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int A[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(N, M, A);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User fuNctioN TeMplate for Java

class Solution {
    int[][] rotateMatrix(int M, int N, int mat[][]) {
        // code here
        
         int row=0,col=0,prev,curr,i;
        while(row<M&&col<N)
        {
            if(row+1==M||col+1==N)
            {
                break;     
            }
            prev=mat[row+1][col];       
            for(i=col;i<N;i++)  
            {               
                curr=mat[row][i];       
                mat[row][i]=prev;       
                prev=curr;      
            }
            row++;              
            for(i=row;i<M;i++)      
            {
                curr=mat[i][N-1];   
                mat[i][N-1]=prev;   
                prev=curr;      
            }
            N--;        
            if(row<M)
            {
                for(i=N-1;i>=col;i--)       
                {
                    curr=mat[M-1][i];       
                    mat[M-1][i]=prev;      
                    prev=curr;      
                }
            }
            M--;       
            if(col<N)       
            {
                for(i=M-1;i>=row;i--)       
                {
                    curr=mat[i][col];   
                    mat[i][col]=prev;       
                    prev=curr;      
                }
            }
            col++;     
        }
        return mat;

    }
        
        

}