//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Sorting options:");
        String sortingOption = scanner.nextLine();
        System.out.println("Enter array:");
        int[] array = new int[10];

        int minDiff;
        for(minDiff = 0; minDiff < 10; ++minDiff) {
            array[minDiff] = scanner.nextInt();
        }

        if (sortingOption.equalsIgnoreCase("Selection")) {
            Sorter.selectionSort(array);
        } else if (sortingOption.equalsIgnoreCase("Insertion")) {
            Sorter.insertionSort(array);
        } else if (sortingOption.equalsIgnoreCase("Merge")) {
            Sorter.mergeSort(array);
        } else if (sortingOption.equalsIgnoreCase("Quick")) {
            Sorter.quickSort(array);
        } else if (!sortingOption.equalsIgnoreCase("NoSort")) {
            System.out.println("Invalid sorting option.");
            return;
        }

        minDiff = Integer.MAX_VALUE;
        int minNum = 0;
        int maxNum = 0;

        for(int i = 0; i < array.length - 1; ++i) {
            for(int j = i + 1; j < array.length; ++j) {
                int diff = Math.abs(array[i] - array[j]);
                if (diff < minDiff) {
                    minDiff = diff;
                    minNum = Math.min(array[i], array[j]);
                    maxNum = Math.max(array[i], array[j]);
                }
            }
        }

        System.out.println("ABS:" + minDiff + ", Min=" + minNum + ", Max=" + maxNum);
    }
}
