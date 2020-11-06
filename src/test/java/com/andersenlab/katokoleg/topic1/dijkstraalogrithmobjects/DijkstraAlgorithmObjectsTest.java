package com.andersenlab.katokoleg.topic1.dijkstraalogrithmobjects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DijkstraAlgorithmObjectsTest {

    @Test
    public void getGraphPath() {
        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");

        vertexA.setNeighbourVertices(vertexB, 10);
        vertexA.setNeighbourVertices(vertexC, 15);
        vertexB.setNeighbourVertices(vertexD, 12);
        vertexB.setNeighbourVertices(vertexF, 15);
        vertexC.setNeighbourVertices(vertexE, 10);
        vertexD.setNeighbourVertices(vertexE, 2);
        vertexD.setNeighbourVertices(vertexF, 1);
        vertexF.setNeighbourVertices(vertexE, 5);

        int graphPath = DijkstraAlgorithmObjects.getGraphPath(vertexA, vertexF);
        Assert.assertEquals(23, graphPath);
    }
}