package com.company;

public class ThreadMin extends Thread {
    private final int[] arr;
    private final int startIndex;
    private final int finishIndex;
    private int min = Integer.MAX_VALUE;
    private int minIndex = -1;

    public ThreadMin(int[] arr, int startIndex, int finishIndex) {
        this.arr = arr;
        this.startIndex = startIndex;
        this.finishIndex = finishIndex;
    }

    @Override
    public void run() {
        // Пошук мінімального елементу та його індексу в межах визначеної частини масиву
        for (int i = startIndex; i < finishIndex; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
    }

    public int getMin() {
        return min;
    }

    public int getMinIndex() {
        return minIndex;
    }
}
