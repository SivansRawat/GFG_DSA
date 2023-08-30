//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj,int source,boolean[] visited){
        Stack<Integer> st = new Stack<>();
        visited[source] = true;
        st.push(source);
        while(!st.isEmpty()) {
            int curr_vertex = st.pop();
            ArrayList<Integer> list = adj.get(curr_vertex);
            for(int i=0;i<adj.get(curr_vertex).size();i++){
                if(!visited[i] && adj.get(curr_vertex).get(i)==1){
                    visited[i] = true;
                    st.push(i);
                }
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[] visited = new boolean[V];
        int province = 0;
        for(int v=0;v<V;v++){
            if(!visited[v]){
                province++;
                dfs(adj,v,visited);
            }
        }
        return province;
    }
};