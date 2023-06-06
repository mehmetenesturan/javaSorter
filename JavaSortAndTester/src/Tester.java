//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.Random;

public class Tester {
    public Tester() {
    }

    public static void main(String[] args) {
        int[] sizes = new int[]{1000, 5000, 10000};
        int[] var2 = sizes;
        int var3 = sizes.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int size = var2[var4];
            int[] array = generateRandomArray(size);
            System.out.println("Array: " + Arrays.toString(array));
            System.out.println("" + findSmallestNumberPair(array));
            System.out.println();
            System.out.println("Sorting Time Measurement");
            measureAndPrintSortingTime(Sorter::noSort, array, "No Sort");
            measureAndPrintSortingTime(Sorter::selectionSort, array, "Selection Sort");
            measureAndPrintSortingTime(Sorter::insertionSort, array, "Insertion Sort");
            measureAndPrintSortingTime(Sorter::mergeSort, array, "Merge Sort");
            measureAndPrintSortingTime(Sorter::quickSort, array, "Quick Sort");
            System.out.println();
        }

    }

    public static int[] generateRandomArray(int size) {
        if (size < 2) {
            System.out.println("Dizi en az 2 sayı içermelidir.");
            return new int[0];
        } else {
            int[] array = new int[size];
            Random random = new Random(System.currentTimeMillis());

            for(int i = 0; i < size; ++i) {
                int randomNumber;
                for(randomNumber = random.nextInt(size * 10); contains(array, randomNumber); randomNumber = random.nextInt(size * 10)) {
                }

                array[i] = randomNumber;
            }

            return array;
        }
    }

    private static boolean contains(int[] array, int number) {
        int[] var2 = array;
        int var3 = array.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            int num = var2[var4];
            if (num == number) {
                return true;
            }
        }

        return false;
    }

    public static String findSmallestNumberPair(int[] array) {
        int smallestDiff = Integer.MAX_VALUE;
        int num1 = 0;
        int num2 = 0;

        for(int i = 0; i < array.length - 1; ++i) {
            for(int j = i + 1; j < array.length; ++j) {
                int diff = Math.abs(array[i] - array[j]);
                if (diff < smallestDiff) {
                    smallestDiff = diff;
                    num1 = array[i];
                    num2 = array[j];
                }
            }
        }

        return "Smallest Number Pair: " + num1 + ", " + num2;
    }

    public static void measureAndPrintSortingTime(SortFunction sortFunction, int[] array, String sortName) {
        int numRuns = 1;
        long[] times = new long[numRuns];

        for(int i = 0; i < numRuns; ++i) {
            int[] copyArray = Arrays.copyOf(array, array.length);
            long startTime = System.currentTimeMillis();
            sortFunction.sort(copyArray);
            long endTime = System.currentTimeMillis();
            times[i] = endTime - startTime;
        }

        Arrays.sort(times);
        long medianTime = times[numRuns / 2];
        System.out.println(sortName + " Median Time: " + medianTime + " ms");
    }

    interface SortFunction {
        void sort(int[] var1);
    }
}
