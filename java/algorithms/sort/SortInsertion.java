/**
 * Insertion Sort using looping
 * 
 * Time  Complexity: O(n^2)
 * Space Complexity: O(n)
 */


class SortInsertion {
    public static void main(String args[]) {
        int arr[] = { 7, 1, 5, 4, 2, 3, 6 };

        System.out.print("Original: ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        
        System.out.print("Sorted\t: ");
        for (int i : insertionSort(arr))
            System.out.print(i + " ");
        System.out.println();
    }


    // insertion sort function
    static int[] insertionSort(int arr[]) {
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            int val = arr[i];

            int k = i - 1;
            while (k != -1 && val < arr[k])
                arr[k + 1] = arr[k--];

            arr[k + 1] = val;
        }


        return arr;
    }
}