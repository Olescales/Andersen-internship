package com.andersenlab.katokoleg.topic1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class QuickSortTest {

    @Test
    public void quickSortTest() {
        int[] testArray = new int[]{9, 8, 1, 7, 6, 4, 5, 11, 2, 4, 8};
        int[] expected = new int[]{1, 2, 4, 4, 5, 6, 7, 8, 8, 9, 11};
        QuickSort.quickSort(testArray, 0, testArray.length - 1);
        Assert.assertArrayEquals(expected, testArray);
    }
}