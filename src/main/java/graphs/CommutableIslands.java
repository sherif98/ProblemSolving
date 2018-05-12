package graphs;


import java.util.*;

public class CommutableIslands {

    public int solve(int n, ArrayList<ArrayList<Integer>> bridges) {
        Graph g = new Graph(n);
        List<Edge> edges = new ArrayList<>();
        for (ArrayList<Integer> edge : bridges) {
            int from = edge.get(0) - 1;
            int to = edge.get(1) - 1;
            int cost = edge.get(2);
            g.add(from, to);
            edges.add(new Edge(from, to, cost));
        }
        Kruskal kruskal = new Kruskal(g, edges);
        return kruskal.cost;
    }

    class Kruskal {

        private UnionFind unionFind;
        private int cost;

        Kruskal(Graph g, List<Edge> edges) {
            unionFind = new UnionFind(g.v);
            solve(g, edges);
        }

        private void solve(Graph g, List<Edge> edges) {
            int cnt = 0;
            Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
            pq.addAll(edges);
            while (cnt < g.v - 1) {
                Edge e = pq.poll();
                if (!unionFind.isConnected(e.from, e.to)) {
                    cost += e.cost;
                    unionFind.union(e.from, e.to);
                    cnt++;
                }
            }
        }
    }

    class Edge {
        private int from;
        private int to;
        private int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    class Graph {
        private int v;
        private List<Integer>[] adj;

        Graph(int v) {
            this.v = v;
            adj = (List<Integer>[]) new List[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void add(int a, int b) {
            adj[a].add(b);
            adj[b].add(a);
        }

        Iterable<Integer> adj(int a) {
            return adj[a];
        }
    }

    class UnionFind {

        private int[] id;
        private int[] height;

        UnionFind(int n) {
            id = new int[n];
            Arrays.setAll(id, i -> i);
            height = new int[n];
        }

        private int getRoot(int a) {
            while (a != id[a]) {
                id[a] = id[id[a]];
                a = id[a];
            }
            return a;
        }

        void union(int a, int b) {
            int aRoot = getRoot(a);
            int bRoot = getRoot(b);
            if (aRoot == bRoot) {
                return;
            }
            if (height[aRoot] > height[bRoot]) {
                id[bRoot] = aRoot;
            } else if (height[bRoot] > height[aRoot]) {
                id[aRoot] = bRoot;
            } else {
                id[bRoot] = aRoot;
                height[aRoot]++;
            }
        }

        boolean isConnected(int a, int b) {
            return getRoot(a) == getRoot(b);
        }
    }
}
