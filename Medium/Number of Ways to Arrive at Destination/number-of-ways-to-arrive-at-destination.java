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

class Pair {
    long first;
    int second;

    public Pair(long first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> road : roads) {
            int u = road.get(0);
            int v = road.get(1);
            int w = road.get(2);
            adj.get(u).add(new Pair(w, v));  // Reversed the order of Pair elements
            adj.get(v).add(new Pair(w, u));  // Reversed the order of Pair elements
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.first));

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        ways[0] = 1;
        dist[0] = 0;
        pq.add(new Pair(0, 0));

        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            long dis = current.first;
            int node = current.second;

            for (Pair neighbor : adj.get(node)) {
                long edW = neighbor.first;
                int adjNode = neighbor.second;

                long newDist = dis + edW;

                if (newDist < dist[adjNode]) {
                    dist[adjNode] = newDist;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(newDist, adjNode));
                } else if (newDist == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return (int) (ways[n - 1] % mod);
    }
}

