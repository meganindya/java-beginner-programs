/**
 * Bubble Sort using looping
 * 
 * Time  Complexity: O(n^2)
 * Space Complexity: O(1)
 */


class SortBubble {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 4, 2, 3, 6 };

        System.out.print("Original: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        
        System.out.print("Sorted\t: ");
        for (int i : bubbleSortOptimized(arr))
            System.out.print(i + " ");
        System.out.println();
    }


    // basic bubble sort
    static int[] bubbleSort(int arr[]) {
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


        return arr;
    }


    // optimized bubble sort
    static int[] bubbleSortOptimized(int arr[]) {
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            // to track whether inner loop makes a change
            boolean changed = false;
            
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    if (!changed) changed = true;
                }
            }

            // if no change is made in inner loop, array is sorted
            if (!changed)   break;
        }


        return arr;
    }
}