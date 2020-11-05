package com.andersenlab.katokoleg.topic1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void binarySearchTest() {
        int[] testArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        int indexOfElement = BinarySearch.binarySearch( 1, testArray);
        int expected = 0;
        Assert.assertEquals(expected, indexOfElement);
    }
}