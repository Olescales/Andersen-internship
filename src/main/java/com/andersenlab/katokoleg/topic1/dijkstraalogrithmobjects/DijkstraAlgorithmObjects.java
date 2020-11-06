package com.andersenlab.katokoleg.topic1.dijkstraalogrithmobjects;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DijkstraAlgorithmObjects {

    private static LinkedList<Vertex> verticesForCheck = new LinkedList<>();

    public static int getGraphPath(Vertex startVertex, Vertex finishVertex) {
        startVertex.setCost(0);
        verticesForCheck.add(startVertex);
        do {
            Vertex lowestVertex = null;
            int lowestCost = Integer.MAX_VALUE;
            for (Vertex vertex : verticesForCheck) {
                if (lowestCost > vertex.getCost()) {
                    lowestVertex = vertex;
                    lowestCost = vertex.getCost();
                }
            }
            verticesForCheck.remove(lowestVertex);
            for (Map.Entry<Vertex, Integer> pair : lowestVertex.getNeighbourVertices().entrySet()) {
                Vertex nextVertex = pair.getKey();
                Integer cost = pair.getValue();
                if (!nextVertex.isVisited() && lowestVertex.getCost() + cost < nextVertex.getCost()) {
                    nextVertex.setCost(lowestVertex.getCost() + cost);
                    LinkedList<Vertex> shortestPath = new LinkedList<>(lowestVertex.getShortestPath());
                    shortestPath.add(nextVertex);
                    nextVertex.setShortestPath(shortestPath);
                    verticesForCheck.add(nextVertex);
                }
            }
            lowestVertex.setVisited(true);
            if (finishVertex.isVisited()) {
               return findNeededVertex(finishVertex.getShortestPath(), finishVertex.getName());
            }
        } while (!verticesForCheck.isEmpty());
        return -1;
    }

    private static int findNeededVertex(List<Vertex> vertices, String vertexName) {
        return vertices.stream()
                .filter(v -> v.getName().equals(vertexName))
                .findAny().get()
                .getCost();
    }
}