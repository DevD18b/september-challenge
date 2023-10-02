package graphs;

import java.util.*;

public class ShortestPathVisitingAllNodes {
    static class pair {
        int nodeValue;
        int mask;

        pair(int nodeValue, int mask) {
            this.nodeValue = nodeValue;
            this.mask = mask;
        }
    }

    public static int countPaths(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] arr : graph) {
            int u = arr[0];
            int v = arr[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        Queue<pair> queue = new LinkedList<>();
        Set<pair> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int maskValue = (1 << i);
            queue.offer(new pair(i, maskValue));
            set.add(new pair(i, maskValue));
        }

        int paths = 0;
        int allVisitedPaths = (int) (Math.pow(2, n) - 1);
        while (queue.isEmpty() == false) {
            pair p = queue.peek();
            queue.poll();
            int currentNode = p.nodeValue;
            int currentNodeMaskValue = p.mask;
            paths++;

            for (int neighbourNodes : adjList.get(currentNode)) {
                int neighbourNodesMask = currentNodeMaskValue | (1 << neighbourNodes);
                if (neighbourNodesMask == allVisitedPaths) {
                    return paths;
                }
                if (set.contains(new pair(neighbourNodes, neighbourNodesMask)) == false) {
                    set.add(new pair(neighbourNodes, neighbourNodesMask));
                    queue.offer(new pair(neighbourNodes, neighbourNodesMask));
                }

            }

        }
        return -1;

    }
}
