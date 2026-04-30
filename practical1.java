import java.util.Random;

public class SelectionSortTime {
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

        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            System.out.println("Pass " + (i + 1) + ":");
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
