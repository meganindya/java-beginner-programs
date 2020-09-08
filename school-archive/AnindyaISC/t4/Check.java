import java.util.*;
class Check extends Record
{
    int noitem,productid;
    Check()
    {
        super();
        super.inp();
        Sellprocess();
    }
    void Sellprocess()
    {
        Scanner sc=new Scanner(System.in);int rm=1;
        do
        {
            System.out.print("\n"+"Enter product id : ");
            productid=sc.nextInt();
            System.out.print("Enter no of items : ");
            noitem=sc.nextInt();
            for(int i=0;i<5;i++)
            {
                if(super.productid[i]==productid)
                {
                    if(super.stock[i]<noitem)
                        System.out.println("Not enough items in stock");
                    else
                    {
                        System.out.println("Price : "+(noitem*super.price[i]));
                        stock[i]-=noitem;
                    }
                    break;
                }
            }
            System.out.print("Do you want to continue - | 1 for yes | 0 for no | : ");
            rm=sc.nextInt();
        }while(rm!=0);
    }
}
/**
 * Output
 * ------
 * Enter product id for item 1 : 101
 * Enter price of item 1 : 15
 * Enter stock for item 1 : 6
 * ---------
 * Enter product id for item 2 : 102
 * Enter price of item 2 : 20
 * Enter stock for item 2 : 15
 * ---------
 * Enter product id for item 3 : 103
 * Enter price of item 3 : 25
 * Enter stock for item 3 : 10
 * ---------
 * Enter product id for item 4 : 104
 * Enter price of item 4 : 30
 * Enter stock for item 4 : 10
 * ---------
 * Enter product id for item 5 : 105
 * Enter price of item 5 : 35
 * Enter stock for item 5 : 25
 * ---------

 * Enter product id : 103
 * Enter no of items : 8
 * Price : 200
 * Do you want to continue - | 1 for yes | 0 for no | : 1
 * 
 * Enter product id : 105
 * Enter no of items : 5
 * Price : 175
 * Do you want to continue - | 1 for yes | 0 for no | : 1
 * 
 * Enter product id : 103
 * Enter no of items : 4
 * Not enough items in stock
 * Do you want to continue - | 1 for yes | 0 for no | : 0
 */