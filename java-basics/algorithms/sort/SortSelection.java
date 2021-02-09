/**
 * Selection Sort using looping
 * 
 * Time  Complexity: O(n^2)
 * Space Complexity: O(1)
 */


class SortSelection {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 4, 2, 3, 6 };

        System.out.print("Original: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        
        System.out.print("Sorted\t: ");
        for (int i : selectionSort(arr))
            System.out.print(i + " ");
        System.out.println();
    }


    // selection sort function
    static int[] selectionSort(int arr[]) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }


        return arr;
    }
}