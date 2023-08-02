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
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if (A[0][0] == 0 || A[X][Y] == 0) return -1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] dist = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }
        
        dist[0][0] = 0;
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                
                if (x >= 0 && x < N && y >= 0 && y < M && A[x][y] == 1 && dist[x][y] == -1) {
                    dist[x][y] = dist[p.x][p.y] + 1;
                    q.add(new Pair(x, y));
                }
            }
        }
        
        return dist[X][Y];
        
        
    }
};