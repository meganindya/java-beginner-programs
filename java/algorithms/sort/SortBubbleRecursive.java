/**
 * Bubble Sort using recursion
 * 
 * Time  Complexity: O(n^2)
 * Space Complexity: O(n^2) due to stacked function calls
 */


class SortBubbleRecursive {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 4, 2, 3, 6 };

        System.out.print("Original: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        
        System.out.print("Sorted\t: ");
        for (int i : bubbleSortRec(arr))
            System.out.print(i + " ");
        System.out.println();
    }


    // recursive bubble sort
    static int[] bubbleSortRec(int arr[]) {
        return bubbleSortRecOpt(arr, 0, 0);
    }

    // overloaded utility function for recursive bubble sort
    static int[] bubbleSortRec(int arr[], int i, int j) {
        int length = arr.length;

        if (i < length) {
            if (j < length - i - 1) {
                // swap
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            
                bubbleSortRec(arr, i, j + 1);
            }
        
            bubbleSortRec(arr, i + 1, 0);
        }


        return arr;
    }

    // overloaded utility function for optimized
    // recursive bubble sort
    static int[] bubbleSortRecOpt(int arr[], int i, int j) {
        int length = arr.length;

        if (i < length) {
            // to track whether inner loop makes a change
            boolean changed = false;
            
            if (j < length - i - 1) {
                //swap
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    if (!changed) changed = true;
                }

                bubbleSortRecOpt(arr, i, j + 1);
            }

            // if no change is made in inner loop, array is sorted
            if (!changed)   return arr;

            bubbleSortRecOpt(arr, i + 1, 0);
        }


        return arr;
    }
}