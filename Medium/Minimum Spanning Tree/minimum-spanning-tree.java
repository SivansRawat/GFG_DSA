//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static class Edge{
        int src;
        int des;
        int wt;
        
        public Edge(int s, int d , int w){
            this.src=s;
            this.des=d;
            this.wt=w;
        }
    }
    
    static void createGraph(int edges[][] , ArrayList<Edge> graph[]){
        
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<edges.length;i++){
            int src=edges[i][0];
            int des=edges[i][1];
            int wt=edges[i][2];
            
            graph[src].add(new Edge(src , des , wt));
            graph[des].add(new Edge(des , src , wt));
            
        }
    }
    
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        
        public Pair(int v , int c){
            this.v=v;
            this.cost=c;
        }
        
    
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }
    static int spanningTree(int V, int E, int edges[][]){
        // Code Here.
        
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(edges , graph);
        
        boolean visited[]=new boolean[V];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int answer=0;
        pq.add(new Pair(0 , 0));
        
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            
            if(!visited[curr.v]){
                visited[curr.v]=true;
                answer+=curr.cost;
                
                
                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e=graph[curr.v].get(i);
                    
                    int desVertex=e.des;
                    int desWt=e.wt;
                    
                    if(!visited[desVertex]){
                        pq.add(new Pair(desVertex , desWt));
                    }
                }
            }
        }
        
        return answer;
        
    }
}