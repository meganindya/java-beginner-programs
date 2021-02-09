import java.util.*;
class Binary_Search
{
 public int recbinsearch(String ar[],String key,int start,int end)
 {
  int mid=(start+end)/2;
  if(start>end)
   return -1;
  if(ar[mid].compareToIgnoreCase(key)==0)
   return mid;
  else if(ar[mid].compareToIgnoreCase(key)<0)
   return recbinsearch(ar,key,mid+1,end);
  else 
   return recbinsearch(ar,key,start,mid-1);
 }
 public static void main()
 {
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter size of array : ");
  int n=sc.nextInt();
  String ar[]=new String[n];
  System.out.println("\n"+"Enter array elements : ");
  for(int i=0;i<n;i++)
   ar[i]=sc.next()+sc.nextLine();
  System.out.print("\n"+"Enter the element you want to search for : ");
  String key=sc.next()+sc.nextLine();
  Binary_Search ob=new Binary_Search();
  int pos=ob.recbinsearch(ar,key,0,(ar.length-1));
  if(pos==-1) System.out.println(key+" was not found!");
  else System.out.println(key+" was found at position "+(pos+1));
 }
}
/**
 * Output
 * ------
Enter size of array : 5

Enter array elements : 
Alpha
Beta
Delta
Iota
Theta

Enter the element you want to search for : Iota
Iota was found at position 4
 */