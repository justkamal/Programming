package Arrays.easy;

public class UpperLower {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int x = 4;
        System.out.println("Inbound value: " + upperBound(arr, x));
        System.out.println("Inbound value: " + lowerBound(arr, x));
    }

    private static int upperBound(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] > x) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }

    private static int lowerBound(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (target > arr[middle]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }
}

//1 3 5 6 | target 7







