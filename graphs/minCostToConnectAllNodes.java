package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class minCostToConnectAllNodes {

    public static int inMst(ArrayList<ArrayList<pair>> adjlist, int V) {
        PriorityQueue<pair> pq = new PriorityQueue<>();

        pq.offer(new pair(0, 0));

        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        int sumOfWeight = 0;
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            int weight = p.weight;
            int node = p.vertex;
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            sumOfWeight += weight;

            for (pair neighbour : adjlist.get(node)) {
                int neighbourNode = neighbour.vertex;
                int neighbour_weight = neighbour.weight;
                if (visited[neighbourNode] == false) {
                    pq.offer(new pair(neighbour_weight, neighbourNode));
                }
            }
        }
        return sumOfWeight;
    }

    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<pair>> adjList = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>()); // Initialize ArrayList for each vertex
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                int x1 = points[i][0];
                int x2 = points[i][1];
                int y1 = points[i][0];
                int y2 = points[i][1];
                int manHatDistance = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                adjList.get(i).add(new pair(j, manHatDistance));
                adjList.get(i).add(new pair(j, manHatDistance));
            }
        }
        return inMst(adjList, points.length);

    }

}

class pair {
    int weight;
    int vertex;

    pair(int weight, int vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }
}