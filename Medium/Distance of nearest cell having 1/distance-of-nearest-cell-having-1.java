//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    
    static class Pair{
        int row;
        int col;
        Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    
    static void bfs(int grid[][],int ans[][])
    {
        Queue<Pair> q=new LinkedList();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new Pair(i,j));
                }
            }
        }
        
        
        while(!q.isEmpty())
        {
            int r=q.peek().row;
            int c=q.peek().col;
            
            q.poll();
            int dr[]={-1,1,0,0};
            int dc[]={0,0,1,-1};
            for(int i=0;i<4;i++)
            {
                int nr=r+dr[i];
                int nc=c+dc[i];
                
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==0 && ans[nr][nc]==0)
                {
                    ans[nr][nc]=ans[r][c]+1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
    
    
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int ans[][]=new int[grid.length][grid[0].length];
        bfs(grid,ans);
        return ans;
    }
}