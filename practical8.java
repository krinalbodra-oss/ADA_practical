import java.util.Arrays;

class KruskalMST {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    static class Subset {
        int parent, rank;
    }

    int V = 5;
    int E = 7;
    Edge[] edges = new Edge[E];

    KruskalMST() {
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
        }
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void kruskalMST() {
        Edge[] result = new Edge[V];
        for (int i = 0; i < V; i++)
            result[i] = new Edge();

        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int e = 0, i = 0;

        while (e < V - 1) {
            Edge next = edges[i++];

            int x = find(subsets, next.src);
            int y = find(subsets, next.dest);

            if (x != y) {
                result[e++] = next;
                union(subsets, x, y);
            }
        }

        System.out.println("Edge \tWeight");
        for (i = 0; i < e; i++)
            System.out.println(result[i].src + " - " + result[i].dest + "\t" + result[i].weight);
    }

    public static void main(String[] args) {
        KruskalMST g = new KruskalMST();

        g.edges[0].src = 0; g.edges[0].dest = 1; g.edges[0].weight = 2;
        g.edges[1].src = 0; g.edges[1].dest = 3; g.edges[1].weight = 6;
        g.edges[2].src = 1; g.edges[2].dest = 2; g.edges[2].weight = 3;
        g.edges[3].src = 1; g.edges[3].dest = 3; g.edges[3].weight = 8;
        g.edges[4].src = 1; g.edges[4].dest = 4; g.edges[4].weight = 5;
        g.edges[5].src = 2; g.edges[5].dest = 4; g.edges[5].weight = 7;
        g.edges[6].src = 3; g.edges[6].dest = 4; g.edges[6].weight = 9;

        g.kruskalMST();
    }
}
