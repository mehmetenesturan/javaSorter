//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;

public class Sorter {
    public Sorter() {
    }

    public static int[] selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; ++i) {
            int minIndex = i;

            int j;
            for(j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            j = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = j;
        }

        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; ++i) {
            int key = arr[i];

            int j;
            for(j = i - 1; j >= 0 && arr[j] > key; --j) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = key;
        }

        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        } else {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            left = mergeSort(left);
            right = mergeSort(right);
            return merge(left, right);
        }
    }

    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;

        int mergedIndex;
        for(mergedIndex = 0; leftIndex < left.length && rightIndex < right.length; ++mergedIndex) {
            if (left[leftIndex] <= right[rightIndex]) {
                merged[mergedIndex] = left[leftIndex];
                ++leftIndex;
            } else {
                merged[mergedIndex] = right[rightIndex];
                ++rightIndex;
            }
        }

        while(leftIndex < left.length) {
            merged[mergedIndex] = left[leftIndex];
            ++leftIndex;
            ++mergedIndex;
        }

        while(rightIndex < right.length) {
            merged[mergedIndex] = right[rightIndex];
            ++rightIndex;
            ++mergedIndex;
        }

        return merged;
    }

    public static int[] quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSortHelper(arr, low, partitionIndex - 1);
            quickSortHelper(arr, partitionIndex + 1, high);
        }

    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        int j;
        for(j = low; j <= high - 1; ++j) {
            if (arr[j] < pivot) {
                ++i;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        j = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = j;
        return i + 1;
    }

    public static void noSort(int[] arr) {
        int minDiff = Integer.MAX_VALUE;
        int[] minPair = new int[2];
        int n = arr.length;

        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff < minDiff) {
                    minDiff = diff;
                    minPair[0] = arr[i];
                    minPair[1] = arr[j];
                }
            }
        }

        System.out.println("Output: " + minDiff + " [" + minPair[0] + ", " + minPair[1] + "]");
    }
}
