import java.util.*;

class SortRecursive {
    static int temp = 0;

    public static void sortBubRec(int a[], int i, int j) {
        if (i < a.length) {
            if (j<a.length-1-i) {
                if (a[j]>a[j+1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            sortBubRec(a, i, j + 1);
        }
        sortBubRec(a, i + 1, 0);
        }
    }

    public static void sortSelRec(int a[], int i, int j) {
        if (i < a.length - 1) {
            int pos = i;
            if (j < a.length) {
                if (a[j] < a[pos])
                    pos=j;
                sortSelRec(a, i, j + 1);
            }
      
            int t = a[i];
            a[i] = a[pos];
            a[pos] = t;

            sortSelRec(a, i + 1, i + 2);
        }
    }

    public static void sortInsRec(int a[], int i, int j) {
        if (i < a.length) {
            if (j == i - 1)
                temp = a[i];
      
            if (j >= 0 && temp < a[j]) {
                a[j + 1] = a[j];
                sortInsRec(a, i, j - 1);
            }
            else {
                a[j + 1] = temp;
                sortInsRec(a, i + 1, i);
            }
        }
    }

    public static void display(int a[]) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        
        System.out.println("\nEnter array elements: ");
        for (int i = 0; i < n; i++)
          a[i] = sc.nextInt();
        
        System.out.println("\nUnsorted array: ");
        display(a);

        System.out.println("\nChoose sorting method: ");
        System.out.println("for Bubble Sort     enter 1");
        System.out.println("for Selection Sort  enter 2");
        System.out.println("for Insertion Sort  enter 3");
        System.out.print("\nEnter choice: ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                sortBubRec(a, 0, 0);
                System.out.println("\nSorted array: ");
                display(a);
                break;
            
            case 2:
                sortSelRec(a, 0, 1);
                System.out.println("\nSorted array:");
                display(a);
                break;
            
            case 3:
                sortInsRec(a, 1, 0);
                System.out.println("\nSorted array:");
                display(a);
                break;
            
            default:
                System.out.println("Wrong choice!!");
        }

        sc.close();
    }
}


/**
 * Output
 * ------
Enter size of array : 3

Enter array elements :
56
13
44
Unsorted array:
56 13 44

Choose sorting method:
for Bubble Sort     enter 1
for Selection Sort  enter 2
for Insertion Sort  enter 3

Enter choice : 2

Sorted array:
13 44 56
*/