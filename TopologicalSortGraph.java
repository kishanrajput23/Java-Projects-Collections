import java.util.*;

class DirectedGraph {
    private int numberOfVertices;
    private List<List<Integer>> adjacencyList;

    public DirectedGraph(int vertices) {
        numberOfVertices = vertices;
        adjacencyList = new ArrayList<>(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    private void performTopologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        for (Integer neighbor : adjacencyList.get(vertex)) {
            if (!visited[neighbor]) {
                performTopologicalSortUtil(neighbor, visited, stack);
            }
        }
        stack.push(vertex);
    }

    public void performTopologicalSort() {
        Stack<Integer> topologicalOrderStack = new Stack<>();
        boolean[] visited = new boolean[numberOfVertices];

        Arrays.fill(visited, false);

        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            if (!visited[vertex]) {
                performTopologicalSortUtil(vertex, visited, topologicalOrderStack);
            }
        }

        // Print the topological order
        System.out.println("Topological Sort Order:");
        while (!topologicalOrderStack.isEmpty()) {
            System.out.print(topologicalOrderStack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Performing Topological Sort:");
        graph.performTopologicalSort();
    }
}