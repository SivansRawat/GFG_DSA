//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Node{
    
    int value ;
    int dist;
    
    public Node(int value , int dist){
        this.value = value;
        this.dist = dist;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        TreeSet<Node> set = new TreeSet<>((node1, node2) -> {
            if (node1.value != node2.value && node1.dist == node2.dist){
                return 1;
            }
            return node1.dist - node2.dist;
        });
        set.add(new Node(S, 0));
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = (int)1e9;
        }
        dist[S] = 0;

        while (!set.isEmpty()) {
            Node node = set.pollFirst();

            for (ArrayList<Integer> adjNodes : adj.get(node.value)) {
                
                int adjNode = adjNodes.get(0);
                int adjNodeDist = adjNodes.get(1);

                if (dist[node.value] + adjNodeDist < dist[adjNode]) {
                    set.add(new Node(adjNode, dist[node.value] + adjNodeDist));
                    dist[adjNode] = dist[node.value] + adjNodeDist;
                }

            }
        }

        return dist;
        
        
        
        
    }
}

