import java.util.*;
class RecSorting
{
 int temp=0;
 public void recbubsort(int a[],int i,int j)
 {
  if(i<a.length)
  {
   if(j<a.length-1-i)
   {
    if(a[j]>a[j+1])
    {
     int t=a[j];a[j]=a[j+1];a[j+1]=t;
    }
    recbubsort(a,i,j+1);
   }
   recbubsort(a,i+1,0);
  }
 }
 public void recselsort(int a[],int i,int j)
 {
  if(i<a.length-1)
  {
   int pos=i;
   if(j<a.length)
   {
    if(a[j]<a[pos]) pos=j;
    recselsort(a,i,j+1);
   }
   int t=a[i];a[i]=a[pos];a[pos]=t;
   recselsort(a,i+1,i+2);
  }
 }
 public void recinssort(int a[],int i,int j)
 {
  if(i<a.length)
  {
   if(j==i-1)
    temp=a[i];
   if(j>=0 && temp<a[j])
   {
    a[j+1]=a[j];
    recinssort(a,i,j-1);
   }
   else
   {
    a[j+1]=temp;
    recinssort(a,i+1,i);
   }
  }
 }
 public void display(int a[])
 {
  for(int i=0;i<a.length;i++)
   System.out.print(a[i]+" ");
 }
 public static void main()
 {
  RecSorting ob=new RecSorting();
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter size of array : ");
  int n=sc.nextInt();
  int a[]=new int[n];
  System.out.println("\nEnter array elements : ");
  for(int i=0;i<n;i++)
   a[i]=sc.nextInt();
  System.out.println("\f"+"Unsorted array:");
  ob.display(a);
  System.out.println("\n\nChoose sorting method:");
  System.out.println("for Bubble Sort     enter 1");
  System.out.println("for Selection Sort  enter 2");
  System.out.println("for Insertion Sort  enter 3");
  System.out.print("\nEnter choice : ");
  int choice=sc.nextInt();
  switch(choice)
  {
   case 1:
    ob.recbubsort(a,0,0);
    System.out.println("\n"+"Sorted array:");
    ob.display(a);
    break;
   case 2:
    ob.recselsort(a,0,1);
    System.out.println("\n"+"Sorted array:");
    ob.display(a);
    break;
   case 3:
    ob.recinssort(a,1,0);
    System.out.println("\n"+"Sorted array:");
    ob.display(a);
    break;
   default: System.out.println("Wrong choice!!");
  }
 }
}
/**
 * Output
 * ------
Enter size of array : 5

Enter array elements : 
22
13
98
35
97

Unsorted array:
22 13 98 35 97 

Choose sorting method:
for Bubble Sort     enter 1
for Selection Sort  enter 2
for Insertion Sort  enter 3

Enter choice : 1/2/3

Sorted array:
13 22 35 97 98 
 */