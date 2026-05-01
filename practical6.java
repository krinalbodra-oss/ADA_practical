import java.util.Arrays;

public class SearchDemo {
    public static void main(String[] args) {
        int[] arr = {45, 12, 78, 34, 23, 89, 10};

        int key = 34;

        int linearResult = linearSearch(arr, key);
        System.out.println("Linear Search Index: " + linearResult);

        Arrays.sort(arr);

        int binaryResult = binarySearch(arr, key);
        System.out.println("Binary Search Index: " + binaryResult);
    }

    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
