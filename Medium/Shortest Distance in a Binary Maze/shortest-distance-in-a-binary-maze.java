//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    int shortestPath(int[][] g, int[] source, int[] des) {
        if(source[0]==des[0] && des[1]==source[1]) return 0;
        // Your code here
        Queue<int[]> qu=new LinkedList();
        qu.add(new int[]{0,source[0],source[1]});
        int[] d= {-1,0,1,0,-1};
        int ans=0;
        g[source[0]][source[1]]=2;
        while(!qu.isEmpty()){
                int[] cur = qu.poll();
                int cc=cur[0];
                if(cur[1]==des[0] && cur[2]==des[1]) return cc;
                
                for(int k=0;k<d.length-1;k++){
                    int x=d[k]+cur[1];
                    int y=d[k+1]+cur[2];
                    if(x>=0 && x<g.length && y>=0 && y<g[0].length && g[x][y]==1){
                        g[x][y]=2;
                        qu.add(new int[]{cc+1,x,y});
                    }
                }
            }
            
        
        return -1;
    }
}