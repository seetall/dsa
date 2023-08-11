package question3;

import java.util.Arrays;

public class b {
    private static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static void bellmanFord(int[][] graph, int source) {
        int V = graph.length;
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : getEdges(graph)) {
                if (distance[edge.source] != Integer.MAX_VALUE &&
                        distance[edge.source] + edge.weight < distance[edge.destination]) {
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : getEdges(graph)) {
            if (distance[edge.source] != Integer.MAX_VALUE &&
                    distance[edge.source] + edge.weight < distance[edge.destination]) {
                System.out.println("Graph contains a negative cycle.");
                return;
            }
        }

        // Print the shortest distances from the source
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": " + distance[i]);
        }
    }

    private static Edge[] getEdges(int[][] graph) {
        int V = graph.length;
        Edge[] edges = new Edge[V * (V - 1) / 2];
        int index = 0;

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges[index++] = new Edge(i, j, graph[i][j]);
                }
            }
        }

        return Arrays.copyOf(edges, index);
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 6, 0, 0, 0, 0},
                {0, 0, 5, -4, 0, 0},
                {0, 0, 0, 0, -2, 0},
                {0, 0, 0, 0, 0, 3},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        int source = 0;
        bellmanFord(graph, source);
    }
}

