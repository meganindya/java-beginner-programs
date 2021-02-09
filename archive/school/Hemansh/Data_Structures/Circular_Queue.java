package Data_Structures;

import java.io.*;
class Circular_Queue
{
    int f=-1,r=-1,size;
    int a[];
    Circular_Queue(int s)
    {
        a=new int[s];
        size=s;
    }
    void push(int n)
    {
        r++;
        if(f==r+1||(f==0&&r==size))
        {
            System.out.println("Queue Overflow");
            for(int i=0;i<size;i++)
              System.out.print(a[i]+" ");
            System.out.println();
            return;
        }
        if(f==-1)
        f=0;
        if(r>=size)
        r=0;
        a[r]=n;
        for(int i=0;i<size;i++)
        System.out.print(a[i]+" ");
        System.out.println();
    }
    void pop()
    {
        if(f==-1&&r==-1)
        System.out.println("Queue Underflow");
        else if(f==r)
        {
            System.out.println("Deleted Element: "+a[f]);
            a[f]=0;
            f=-1;
            r=-1;
        }
        else
        {
            System.out.println("Deleted Element: "+a[f]);
            a[f]=0;
            f++;
            if(f==size)
            f=0;
        }
        for(int i=0;i<size;i++)
        System.out.print(a[i]+" ");
        System.out.println();
    }
    void main() throws IOException
    {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        System.out.println("Enter size of queue");
        int s = Integer.parseInt(br.readLine());
        Circular_Queue ob = new Circular_Queue(s);
        for(int i=0;;i++)
        {
            System.out.println("Press 1 to add element");
            System.out.println("Press 2 to delete element");
            System.out.println("Press 3 to exit");
            int ch = Integer.parseInt(br.readLine());
            switch(ch)
            {
                case 1:
                System.out.println("Enter element to push");
                int p = Integer.parseInt(br.readLine());
                ob.push(p);
                break;
                case 2:
                ob.pop();
                break;
                case 3:
                System.out.println("Have a nice day");
                System.exit(0);
                break;
                default:
                System.out.println("Wrong choice");
            }
        }
    }
}