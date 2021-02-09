class Queue
{
    int cap,front,rear,a[];
    Queue(int c)
    {
        rear=-1;
        front=-1;
        cap=c;
        a=new int[cap];
    }
    void insert(int ele)
    {
        if(rear==-1 && front==-1)
        {
            rear=0;
            front=0;
            a[rear]=ele;
        }
        else if(rear==cap-1)
        {
            System.out.print("Queue is full");
            return;
        }
        else
        {
            rear=rear+1;
            a[rear]=ele;
        }
    }
    void delete()
    {
        if(front==cap)
        {
            System.out.print("Nothing to be deleted");
        }
        else
        {
            System.out.print("Element deleted is "+a[front]);
            front=front+1;
            rear=rear-1;
        }
    }
    void display()
    {
        for(int i=front;i<=rear;i++)
        {
            System.out.println(a[i]);
        }
    }
}