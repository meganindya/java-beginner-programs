import java.util.*;
class dq
{
    int arr[];
    int lim,front,rear;
    dq(int l)
    {
        lim=l;front=0;
        rear=-1;
        arr=new int[lim];
    }

    void addfront(int val)
    {
        if (front==0)
            System.out.println("overflow from front");
        else
        {front--;
            arr[front]=val;
        }
    }

    void addrear(int val)
    {
        if (rear<lim-1)
        {
            rear++;
            arr[rear]=val;
        }
        else
            System.out.println("the deque is overflow");
    }

    int popfront()
    {int popped=-999;
        if(front<=rear)
        {
            popped=arr[front++];
        }

        return popped;
    }

    int poprear()
    {int popped=-999;
        if (front>rear || rear==-1 ||front==-1)
        {return popped;}
        else
        {
            popped=arr[rear--];
            return popped;
        }

    }

    void display()
    {if (front<=rear)
        {System.out.println("the elements of the dequeue are");

            for(int i=front;i<=rear;i++)
                System.out.println(arr[i]);
        }
        else
            System.out.println("the queue is undeflow");
    }

    public static void main()
    {int ch=0;
        Scanner sc=new Scanner(System.in);
        dq ob=new dq(10);
        do
        {
            System.out.println("1 to enter from front");
            System.out.println("2 to enter from rear");
            System.out.println("3 to delete from front");
            System.out.println("4 to delete from rear");
            System.out.println("press 5 to display");
            System.out.println("enter your choice");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("enter the no");
                int num=sc.nextInt();
                ob.addfront(num);
                break;
                case 2:
                System.out.println("enter the no");
                int nu=sc.nextInt();
                ob.addrear(nu);
                break;
                case 3:
                int x=ob.popfront();
                if (x==-999)
                    System.out.println("dq is empty");
                else
                    System.out.println("element deleted from front="+x);
                break;
                case 4:
                int nm=ob.poprear();
                if (nm==-999)
                    System.out.println("dq is empty");
                else
                    System.out.println("element popped from rear="+nm);
                case 5:
                ob.display();
                break;
            }
        }while(ch<=5);
    }
}