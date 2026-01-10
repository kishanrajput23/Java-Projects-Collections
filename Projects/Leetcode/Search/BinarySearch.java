/**
 * References:
 * https://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 * https://www.geeksforgeeks.org/greedy-algorithms-set-7-dijkstras-algorithm-for-adjacency-list-representation/
 * https://www.geeksforgeeks.org/printing-paths-dijkstras-shortest-path-algorithm/
 * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-set-in-stl/
 */

/**
 * All edge weights are non-negative.
 */
public class Dijkstra {
    // Adjacency Matrix Representation
    /**
     * Output shortest paths distance from the source to all the vertices.
     */
    public int[] shortestDistancesFrom(int[][] graph, int src) {
        if (graph == null || graph.length == 0 || graph[0].length == 0) return new int[0];
        int len = graph.length;
        int[] dist = new int[len];
        Set<Integer> sptSet = new HashSet[len];

        // initialization
        for (int i = 0; i < len; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        while (sptSet.size() < len) {
            int u = extractMin(dist, sptSet);
            sptSet.add(u);

            for (int v=0; v<len; v++) {
                // relaxation
                if (!sptSet.contains(v) && graph[u][v] > 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return dist;
    }

    // This can be optimized by MinHeap
    private int extractMin(int[] dist, Set<Integer> sptSet) {
        int minIdx = -1;
        int minVal = Integer.MAX_VALUE;
        for (int i=0; i<dist.length; i++) {
            if (!sptSet.contains(i) && dist[i] < minVal) {
                minIdx = i;
                minVal = dist[i];
            }
        }
        return minIdx;
    }

    /**
     * Output the shortest path distance from the source to the destination.
     */
    public int shortestDistance(int[][] graph, int src, int dest) {
        if (graph == null || graph.length == 0 || graph[0].length == 0) return new int[0];
        int len = graph.length;
        int[] dist = new int[len];
        Set<Integer> sptSet = new HashSet[len];

        // initialization
        for (int i = 0; i < len; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        while (sptSet.size() < len) {
            int u = minDistance(dist, sptSet);
            // early return when you fidn the target
            if (u = target) return dist[u];
            sptSet.add(u);

            for (int v=0; v<len; v++) {
                // relaxation
                if (!sptSet.contains(v) && graph[u][v] > 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return -1;
    }

    /**
     * Output shortest path from the source to the destination.
     */
    public List<Integer> shortestPath(int[][] graph, int src, int dest) {
        if (graph == null || graph.length == 0 || graph[0].length == 0) return new int[0];
        int len = graph.length;
        int[] dist = new int[len];
        int[] parent = new int[len];
        Set<Integer> sptSet = new HashSet[len];

        // initialization
        for (int i = 0; i < len; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        dist[src] = 0;

        while (sptSet.size() < len) {
            int u = extractMin(dist, sptSet);
            if (u = target) return constructShortestPath(parent, src, dest);
            sptSet.add(u);

            for (int v=0; v<len; v++) {
                // relaxation
                if (!sptSet.contains(v) && graph[u][v] > 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        return dist;
    }

    private List<Integer> constructShortestPath(int[] parent, int src, int dest) {
        LinkedList<Integer> path = new LinkedList<>();
        path.add(dest);
        while (path.getFirst() != src) {
            int head = path.getFirst();
            if (parent[head] == head) return new LinkedList<>();
            path.addFirst(parent[head]);
        }
        return path;
    }

}
