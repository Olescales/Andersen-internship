package com.andersenlab.katokoleg.topic1;

public class QuickSort {

    public static void quickSort(int[] arrayForSort, int initLeft, int initRight) {
        int currentRight = initRight;
        int currentLeft = initLeft;

        int middle = initLeft + (initRight - initLeft) / 2;
        int referenceElement = arrayForSort[middle];

        do {
            while (arrayForSort[currentLeft] < referenceElement) {
                currentLeft++;
            }
            while (arrayForSort[currentRight] > referenceElement) {
                currentRight--;
            }
            if (currentLeft <= currentRight) {
                int temp = arrayForSort[currentLeft];
                arrayForSort[currentLeft] = arrayForSort[currentRight];
                arrayForSort[currentRight] = temp;
                currentLeft++;
                currentRight--;
            }
        } while (currentLeft <= currentRight);

        if (initLeft < currentRight) {
            quickSort(arrayForSort, initLeft, currentRight);
        }
        if (initRight > currentLeft) {
            quickSort(arrayForSort, currentLeft, initRight);
        }
    }
}
