package com.andersenlab.katokoleg.topic1;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        int[][] initData = initData();
        int pathLength = getPathLength(initData, 2, 1);
        System.out.println(pathLength);
    }

    public static int[][] initData() {
        int[][] graphs = new int[3][3];
        graphs[0][1] = 1;
        graphs[0][2] = 1;
        graphs[1][0] = 4;
        graphs[1][2] = 1;
        graphs[2][0] = 2;
        graphs[2][1] = 1;
        return graphs;
    }

    public static int getPathLength(int[][] graphs, int beginVertex, int finishVertex) {
        int[] vertexCosts = new int[graphs.length];
        int[] parentVertex = new int[graphs.length];

        boolean[] visitedVertexes = new boolean[graphs.length];
        boolean fin = visitedVertexes[finishVertex - 1];

        int currentVertex = beginVertex - 1;
        int minVertex = currentVertex;
        do {
            if (currentVertex == finishVertex - 1) {
                break;
            }

            for (int outgoingVertex = 0; outgoingVertex < graphs.length; outgoingVertex++) {
                if (graphs[currentVertex][outgoingVertex] == 0 || visitedVertexes[outgoingVertex]) {
                    continue;
                }
                if (graphs[currentVertex][outgoingVertex] != 0 || graphs[currentVertex][minVertex] > graphs[currentVertex][outgoingVertex]) {
                    minVertex = outgoingVertex;
                }
                if (vertexCosts[outgoingVertex] == 0 || vertexCosts[outgoingVertex] > vertexCosts[currentVertex] + graphs[currentVertex][outgoingVertex]) {
                    vertexCosts[outgoingVertex] = vertexCosts[currentVertex] + graphs[currentVertex][outgoingVertex];
                    parentVertex[minVertex] = outgoingVertex;
                }
            }
            visitedVertexes[currentVertex] = true;
            currentVertex = minVertex;

        } while (!fin);
        return vertexCosts[currentVertex];
    }
}
