//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static class Graph {
		class Node {
			private int vertex;
			private long cost;

			public Node(int v, long cost) {
				this.vertex = v;
				this.cost = cost;
			}
		}

		private int V;
		private List<ArrayList<Node>> adj;

		private int mod = (int) (1e9 + 7);

		public Graph(int v) {
			this.V = v;
			this.adj = new ArrayList<ArrayList<Node>>(this.V);
			for (int i = 0; i < this.V; i++) {
				this.adj.add(new ArrayList<Node>());
			}
		}

		public void addEdge(int u, int v, int weight) {
			this.adj.get(u).add(new Node(v, weight));
			this.adj.get(v).add(new Node(u, weight));
		}

		public int dijkstra(int src, int dst, int n) {
			PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> Long.compare(o1.cost, o2.cost));
			long[] distance = new long[n];
			int[] ways = new int[n];
			Arrays.fill(distance, Integer.MAX_VALUE);
			Arrays.fill(ways, 0);
			distance[0] = 0;
			ways[0] = 1;
			pq.add(new Node(src, 0));
			while (pq.size() != 0) {
				Node node = pq.poll();
				int u = node.vertex;
				long dis = node.cost;
				for (Node neighbour : adj.get(u)) {
					int v = neighbour.vertex;
					long edW = neighbour.cost;
					if (dis + edW < distance[v]) {
						distance[v] = dis + edW;
						pq.add(new Node(v, dis + edW));
						ways[v] = ways[u];
					} else if (dis + edW == distance[v]) {
						ways[v] = (ways[v] + ways[u]) % mod;
					}
				}
			}
			return (int) (ways[n - 1] % mod);
		}
	}

	static int countPaths(int n, List<List<Integer>> roads) {
		Graph graph = new Graph(n);
		int m = roads.size();
		for (int i = 0; i < m; i++) {
			graph.addEdge(roads.get(i).get(0), roads.get(i).get(1), roads.get(i).get(2));
		}
		return graph.dijkstra(0, n - 1, n);
	}
}