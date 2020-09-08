package One_D_Sorting;
class Merge_Sort
{
    static int ar[];
    public static void MergeSort(int l, int h)
    {
        if(l<h)
        {
            int mid=(l+h)/2;
            MergeSort(l,mid);
            MergeSort(mid+1,h);
            Merge(l,h,mid);
        }
    }
    public static void Merge(int l, int h, int mid) 
    {   
        int a[]=new int[h];
        int i,j,k;
        for(i=l;i<h;i++)
        a[i]=ar[i];
        for(i=l;i<mid+1;i++)
        System.out.print(ar[i]+" ");
        System.out.println();
        for(i=mid+1;i<h;i++)
        System.out.print(ar[i]+" ");
        System.out.println();
        i=l;
        j=mid+1;
        k=l;
        while (i < mid+1 && j < h)
        {
            if (a[i] < a[j])       
                ar[k++] = a[i++];
            else        
                ar[k++] = a[j++];               
        }
        while (i < mid+1)  
            ar[k++] = a[i++];
        while (j < h)    
            ar[k++] = a[j++];
        for(i=l;i<h;i++)
        System.out.print(ar[i]+" ");
        System.out.println();
    }
    public static void main(int a[])
    {
        Merge_Sort ob = new Merge_Sort();
        ob.ar=a;
        ob.MergeSort(0,a.length);
        for(int i = 0;i < a.length; i++)
        System.out.print(ar[i]+" ");
    }
}
        