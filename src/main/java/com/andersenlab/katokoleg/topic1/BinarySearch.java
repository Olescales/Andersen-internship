package com.andersenlab.katokoleg.topic1;

public class BinarySearch {

    public static int binarySearch(int number, int[] source) {
        int left = 0;
        int right = source.length;
        int middle = left + (right - left) / 2;

        while (left < right) {
            if (number == source[middle]) {
                return middle;
            } else if (number > source[middle]) {
                left = middle;
            } else {
                right = middle;
            }
            middle = left + (right - left) / 2;
        }
        return -1;
    }
}
