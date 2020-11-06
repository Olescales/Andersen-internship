package com.andersenlab.katokoleg.topic1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DijkstraAlgorithmMatrixTest {

    @Test
    public void getPathLengthTest1() {
        int[][] graph = new int[3][3];
        graph[0][1] = 1;
        graph[0][2] = 1;
        graph[1][0] = 4;
        graph[1][2] = 1;
        graph[2][0] = 2;
        graph[2][1] = 1;
        DijkstraAlgorithmMatrix dijkstraAlgorithm = new DijkstraAlgorithmMatrix();
        int actualPathLength = dijkstraAlgorithm.getPathLength(graph, 2, 1);
        Assert.assertEquals(3, actualPathLength);
    }

    @Test
    public void getPathLengthTest2() {
        int[][] graph = new int[4][4];
        graph[0][1] = 6;
        graph[0][2] = 2;
        graph[2][1] = 3;
        graph[1][3] = 1;
        graph[2][3] = 5;
        DijkstraAlgorithmMatrix dijkstraAlgorithm = new DijkstraAlgorithmMatrix();
        int actualPathLength = dijkstraAlgorithm.getPathLength(graph, 1, 4);
        Assert.assertEquals(6, actualPathLength);
    }

    @Test
    public void getPathLengthTest3() {
        int[][] graph = new int[4][4];
        graph[0][1] = 6;
        graph[0][2] = 2;
        graph[2][1] = 3;
        graph[1][3] = 1;
        graph[2][3] = 5;
        DijkstraAlgorithmMatrix dijkstraAlgorithm = new DijkstraAlgorithmMatrix();
        int actualPathLength = dijkstraAlgorithm.getPathLength(graph, 4, 1);
        Assert.assertEquals(-1, actualPathLength);
    }

    @Test
    public void getPathLengthTest4() {
        int[][] graph = new int[4][4];
        graph[0][1] = 6;
        graph[0][2] = 2;
        graph[2][1] = 3;
        graph[1][3] = 1;
        graph[2][3] = 5;
        DijkstraAlgorithmMatrix dijkstraAlgorithm = new DijkstraAlgorithmMatrix();
        int actualPathLength = dijkstraAlgorithm.getPathLength(graph, 1, 1);
        Assert.assertEquals(0, actualPathLength);
    }

    @Test
    public void getPathLengthTest5() {
        int[][] graph = new int[4][4];
        graph[0][1] = 5;
        graph[0][2] = 9;
        graph[0][3] = 100;
        graph[1][0] = 100;
        graph[1][2] = 2;
        graph[1][3] = 8;
        graph[2][0] = 100;
        graph[2][1] = 100;
        graph[2][3] = 7;
        graph[3][0] = 4;
        graph[3][1] = 100;
        graph[3][2] = 100;
        DijkstraAlgorithmMatrix dijkstraAlgorithm = new DijkstraAlgorithmMatrix();
        int actualPathLength = dijkstraAlgorithm.getPathLength(graph, 2, 1);
        Assert.assertEquals(12, actualPathLength);
    }
}