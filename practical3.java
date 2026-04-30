import java.util.Random;

public class InsertionSortTime {
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

        for (int i = 1; i < size; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

            System.out.println("Pass " + i + ":");
            printArray(arr);
        }

        long end = System.nanoTime();

        System.out.println("Sorted Array:");
        printArray(arr);

        System.out.println("Execution Time: " + (end - start) + " ns");
    }

    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
