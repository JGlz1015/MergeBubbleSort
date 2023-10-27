//package Merge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sort {

    public static void mergeSort(List<Integer> list, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            mergeSort(list, start, middle);
            mergeSort(list, middle + 1, end);

            merge(list, start, middle, end);
        }
    }

    private static void merge(List<Integer> list, int start, int middle, int end) {
        int n1 = middle - start + 1;
        int n2 = end - middle;

        List<Integer> left = new ArrayList<>(list.subList(start, middle + 1));
        List<Integer> right = new ArrayList<>(list.subList(middle + 1, end + 1));

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (left.get(i) <= right.get(j)) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < n1) {
            list.set(k++, left.get(i++));
        }

        while (j < n2) {
            list.set(k++, right.get(j++));
        }
    }

    public static void bubbleSort(List<Integer> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static void mainFunction(List<Integer> list, String algorithm) {
        long startTime = System.nanoTime();

        if (algorithm.equals("MergeSort")) {
            mergeSort(list, 0, list.size() - 1);
        } else if (algorithm.equals("BubbleSort")) {
            bubbleSort(list);
        }

        long endTime = System.nanoTime();
        long runtime = endTime - startTime;

        System.out.println(algorithm + " Sorted list: " + list);
        System.out.println(algorithm + " Sort time: " + runtime + " nanoseconds");
    }

    public static void main(String[] args) {
        // Random Array
        List<Integer> numbers = generateRandomArray(10); 

        // MergeSort
        mainFunction(new ArrayList<>(numbers), "MergeSort");

        // BubbleSort
        mainFunction(new ArrayList<>(numbers), "BubbleSort");
    }

    
    private static List<Integer> generateRandomArray(int size) {
        List<Integer> randomArray = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray.add(random.nextInt(100)); 
        }

        return randomArray;
    }
}

