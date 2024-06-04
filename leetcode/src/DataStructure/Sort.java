package DataStructure;

public class Sort {
    public static int swapTimes = 0;



    public static void bubbleSort(int[] arr, int n) {
        for(int i = 0; i < n - 1; ++i) {
            boolean swapped = false;

            for(int j = 0; j < n - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    ++swapTimes;
                }
            }

            if (!swapped) {
                break;
            }
        }

    }

    public static void printArray(int[] arr, int size) {
        for(int i = 0; i < size; ++i) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 1, 2};
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);
        System.out.println("swap times: " + swapTimes);
    }
}
