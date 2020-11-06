package com.andersenlab.katokoleg.topic1.dijkstraalogrithmobjects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Vertex {

    private String name;
    private Map<Vertex, Integer> neighbourVertices = new HashMap<>();
    private int cost;
    private boolean visited;
    private List<Vertex> shortestPath = new LinkedList<>();

    public Vertex(String name) {
        this.name = name;
        this.cost = 10000;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Map<Vertex, Integer> getNeighbourVertices() {
        return neighbourVertices;
    }

    public List<Vertex> getShortestPath() {
        return shortestPath;
    }

    public String getName() {
        return name;
    }

    public void setShortestPath(List<Vertex> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public void setNeighbourVertices(Vertex vertex, Integer cost) {
        neighbourVertices.put(vertex, cost);
    }
}
