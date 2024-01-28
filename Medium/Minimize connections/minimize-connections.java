//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] connections = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.minimumConnections(n,connections);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class DisJointSet{
	int[] parent,rank;
	public DisJointSet(int n) {
		parent = new int[n+1];
		rank = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			parent[i] = i;
		}
	}
	
	public int findParent(int node) {
		if(parent[node] == node) {
			return node;
		}else {
			int result = findParent(parent[node]);
			parent[node] = result;
			return result;
		}
	}
	
	public void unionByRank(int u,int v) {
		int uParent = findParent(u);
		int vParent = findParent(v);
		if(uParent == vParent) {
			return ;
		}
		if(rank[uParent] < rank[vParent]) {
			parent[uParent] = vParent;
		}else if(rank[vParent]<rank[uParent]){
			parent[vParent] = uParent;
		}else {
			parent[vParent] = uParent;
			rank[uParent]++;
		}
	}
	
}

class Solution {
    public static int minimumConnections(int n, int[][] connections) {
       
       int edges = connections.length;
       if((n-edges)>1){
           return -1;
       }else{
           DisJointSet ds = new DisJointSet(n);
           for(int i=0;i<connections.length;i++){
               ds.unionByRank(connections[i][0],connections[i][1]);
           }
           int numberOfComponent = 1;
           
           HashSet<Integer> set = new HashSet<>();
        //   set.add(connections[0][0]);
           for(int i=0;i<n;i++){
               int x = ds.findParent(i);
               if(ds.findParent(connections[0][0]) != x){
                   if(!set.contains(x)){
                        numberOfComponent++;
                        set.add(x);
                   }
               }
           }
           return numberOfComponent-1;
       }
       
    }

}