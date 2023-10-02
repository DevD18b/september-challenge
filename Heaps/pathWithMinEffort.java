package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class pathWithMinEffort {
    public static int minEffort(int[][] grid) {

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        pq.offer(new pair(0, 0, 0));

        int[][] difference = new int[grid.length][grid[0].length];

        for (int[] arr : difference) {
            Arrays.fill(arr, -1);
        }
        int[][] direction = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };

        difference[0][0] = 0;
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            int x = p.x;
            int y = p.y;
            int distance = p.distance;
            if (x == grid.length && y == grid[0].length)
                return distance;
            for (int[] arr : direction) {
                int newRow = x + arr[0];
                int newCol = y + arr[1];
                if (isSafe(newRow, newCol, grid)) {
                    int minEffort = Math.min(Math.abs(grid[newRow][newCol] - grid[x][y]), distance);
                    if (minEffort < difference[newRow][newCol]) {
                        difference[newRow][newCol] = minEffort;
                        pq.offer(new pair(newRow, newCol, minEffort));
                    }
                }
            }
        }
        return -1;

    }

    public static boolean isSafe(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}

class pair {
    int x;
    int y;
    int distance;

    pair(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
