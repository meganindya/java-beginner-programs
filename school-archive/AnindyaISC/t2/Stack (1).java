class Stack
{
    int cap,top,a[];
    Stack(int c)
    {
        cap=c;a=new int[cap];
        top=-1;
    }
    void push(int ele)
    {
        if(top==cap-1)
            return;
        else
            top=top+1;
        a[top]=ele;
    }
    int pop()
    {
        if(top==-1)
            return -1;
        else
        {
            int ele=a[top];
            top=top-1;
            return ele;
        }
    }
    void display()
    {
        for(int i=top;i>=0;i--)
        {
            System.out.println(a[i]);
        }
    }
}