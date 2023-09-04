//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        
        
        int r = a.length;
        int c = a[0].length;

        // 1a) Capture unsurrounded regions - top and bottom row (replace O with P)
        for(int i=0;i<c;i++){
            if(a[0][i]=='O'){
                dfs(0, i, a);
            }
            if(a[r-1][i]=='O'){
                dfs(r-1, i, a);
            }
        }
        // 1b) Capture unsurrounded regions - Left and right columns (replace O with P)
        for(int j=0;j<r;j++){
            if(a[j][0]=='O'){
                dfs(j, 0, a);
            }
            if(a[j][c-1]=='O'){
                dfs(j, c-1, a);
            }
        }

        //main loop
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j]=='O'){
                    a[i][j]='X'; //making the soraunded regions 'O' --> 'X'
                }
                if(a[i][j]=='P'){
                    a[i][j]='O'; //making the soraunded regions 'P' --> 'O'
                }
            }
        }
        
        
        return a;
    }
    //dfs method
    public static void dfs(int i, int j, char[][] a){
        //base case 
        if(i<0 || j<0 || i>=a.length || j>=a[0].length || a[i][j]!='O'){
            return;
        }
        //make the 'O' position as 'P'
        a[i][j] = 'P';
        //call dfs for all direction
        dfs(i+1, j, a);
        dfs(i-1, j, a);
        dfs(i, j+1, a);
        dfs(i, j-1, a);
    }
}