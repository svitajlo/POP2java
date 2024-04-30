package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        int dim = 10000000; // Розмір масиву
        int threadNum = 20; // Кількість потоків

        // Створення масиву з випадковими від'ємними числами
        int[] arr = generateArray(dim);

        // Створення об'єкта для обробки масиву у паралельних потоках
        ArrayProcessor arrayProcessor = new ArrayProcessor(arr, threadNum);

        // Знаходження мінімального елементу та його індексу
        Pair<Integer, Integer> minResult = arrayProcessor.findMin();

        // Вивід результатів
        System.out.println("Min value: " + minResult.getFirst() + " | Index: " + minResult.getSecond());
    }

    // Метод для генерації масиву з випадковими від'ємними числами
    private static int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, 0);
        }
        return arr;
    }
}
