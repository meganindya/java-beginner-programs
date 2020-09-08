import java.util.*;
class Record
{
    int productid[],price[],stock[];
    Record()
    {
        productid=new int[5];
        price=new int[5];
        stock=new int[5];
    }
    void inp()
    {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
            System.out.print("Enter product id for item "+(i+1)+" : ");
            productid[i]=sc.nextInt();
            System.out.print("Enter price of item "+(i+1)+" : ");
            price[i]=sc.nextInt();
            System.out.print("Enter stock for item "+(i+1)+" : ");
            stock[i]=sc.nextInt();
            System.out.println("---------");
        }
    }
}