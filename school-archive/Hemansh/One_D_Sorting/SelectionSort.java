package One_D_Sorting;
 public class SelectionSort
 {
       public static void main(double sortingList[])
       {
            sort(sortingList);
            System.out.println("Sorted list - ");
            for (int i=0; i<sortingList.length; i++)
                 System.out.print(sortingList[i]+",");
       }
       public static void sort(double[] list) 
       {
           sort(list, 0, list.length - 1);
            }
        public static void sort(double[] list, int low, int high) 
        {
             if (low < high) {
                     int indexOfMin = low;
                     double min = list[low];
                     for (int i = low + 1; i <= high; i++) {
                           if (list[i] < min) {
                                  min = list[i];
                                  indexOfMin = i;
                           }
                     }
                     // Swap the smallest number in list
                     list[indexOfMin] = list[low];
                     list[low] = min;
                     // Sort the remaining list
                     sort(list, low + 1, high);
              }
       }
}
/*
 -SelectionSort.main({1,5,3,7,2,9,1,9});
  Sorted list - 
  1.0,1.0,2.0,3.0,5.0,7.0,9.0,9.0,
 -SelectionSort.main({123,876,76,23,54,90,110,239,300});
  Sorted list - 
  23.0,54.0,76.0,90.0,110.0,123.0,239.0,300.0,876.0,
 -SelectionSort.main({65,21,10,99,87,50,12,87,67,88,73});
  Sorted list - 
  10.0,12.0,21.0,50.0,65.0,67.0,73.0,87.0,87.0,88.0,99.0,
 */