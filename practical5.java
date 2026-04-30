import java.util.Random;

public class QuickSortTime {
    static int pass = 1;

    public static void main(String[] args) {
        int size = 10;
        int[] arr = new int[size];
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(100);
        }

        System.out.println("Original Array:");
        printArray(arr);

        long start = System.nanoTime();

        quickSort(arr, 0, size - 1);

        long end = System.nanoTime();

        System.out.println("Sorted Array:");
        printArray(arr);

        System.out.println("Execution Time: " + (end - start) + " ns");
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            System.out.println("Pass " + (pass++) + ":");
            printArray(arr);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
