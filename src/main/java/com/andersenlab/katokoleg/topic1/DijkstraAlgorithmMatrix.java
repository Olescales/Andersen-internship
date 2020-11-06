package com.andersenlab.katokoleg.topic1;

import java.util.Arrays;

public class DijkstraAlgorithmMatrix {

    public int getPathLength(int[][] graph, int beginVertex, int finishVertex) {
        if (beginVertex == finishVertex) {
            return 0;
        }

        int[] costs = new int[graph.length];
        Arrays.fill(costs, 10000);
        costs[beginVertex - 1] = 0;

        boolean[] visited = new boolean[graph.length];
        int current = beginVertex - 1;
        do {
            int minVertex = -1;
            for (int checked = 0; checked < graph.length; checked++) {
                if (graph[current][checked] == 0 || visited[checked]) {
                    continue;
                }
                if (minVertex == -1 || !visited[current] && graph[current][minVertex] > graph[current][checked]) {
                    minVertex = checked;
                }

                if (costs[checked] == 0 || costs[checked] > costs[current] + graph[current][checked]) {
                    costs[checked] = costs[current] + graph[current][checked];
                }
            }
            visited[current] = true;
            current = minVertex;
            if (visited[finishVertex - 1]) {
                return costs[finishVertex - 1];
            }
        } while (current != -1);
        return -1;
    }
}