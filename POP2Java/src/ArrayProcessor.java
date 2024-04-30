package com.company;

public class ArrayProcessor {
    private final int[] arr;
    private final int threadNum;

    public ArrayProcessor(int[] arr, int threadNum) {
        this.arr = arr;
        this.threadNum = threadNum;
    }

    // Метод для пошуку мінімального елементу та його індексу
    public Pair<Integer, Integer> findMin() {
        ThreadMin[] threads = new ThreadMin[threadNum];
        int chunkSize = arr.length / threadNum;

        // Створення та запуск потоків для обробки частин масиву
        for (int i = 0; i < threadNum; i++) {
            int startIndex = i * chunkSize;
            int finishIndex = (i == threadNum - 1) ? arr.length : (i + 1) * chunkSize;
            threads[i] = new ThreadMin(arr, startIndex, finishIndex);
            threads[i].start();
        }

        int min = Integer.MAX_VALUE;
        int index = -1;

        // Очікування завершення потоків та знаходження мінімального елементу та його індексу
        try {
            for (ThreadMin thread : threads) {
                thread.join();
                if (thread.getMin() < min) {
                    min = thread.getMin();
                    index = thread.getMinIndex();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Pair<>(min, index);
    }
}
