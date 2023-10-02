package greedy;

import java.util.*;

class frequency implements Comparable<frequency> {
    int index;
    int count;

    frequency(int index, int count) {
        this.count = count;
        this.index = index;
    }

    @Override
    public int compareTo(frequency o) {
        int result = this.count - o.count;
        if (result == 0) {
            return this.index - o.index;
        }
        return result;
    }
}

public class kWeakestRowsInAMatrix {

    public static ArrayList<Integer> driver(int[][] grid, int k) {
        PriorityQueue<frequency> pq = new PriorityQueue<>();

        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            int col = 0;
            while (col < grid[i].length && grid[i][col] != 0) {
                count++;
                col++;
            }
            pq.offer(new frequency(i, count));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(pq.poll().index);
        }

        return ans;

    }
}
