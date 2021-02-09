import java.io.*;
class node
{
    node start,head,inm,prv,save,link;
    int ch=0,size,data;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    node()
    {}
    node(int n,node l)
    {
        data=n;
        link=l;
    }
    
    void main()throws IOException
    {   head=new node();
        do
        {
            System.out.println("Press1:to create");
            System.out.println("Press 2:to insert from beginning");
            System.out.println("Press 3:to insert from end:");
            System.out.println("Press 4:to insert in middle");
            System.out.println("Press 5:to delete from beginning");
            System.out.println("Press 6:to delete from end");
            System.out.println("Press 7:to delete in middle");
            System.out.println("Press 8:to reverse");
            System.out.println("Press 9:to merge");
            System.out.println("Press 10:to split");
            System.out.println("Press 11:to calculate sum of all the elements");
            System.out.println("Press 12:to display");
            System.out.println("---------------------------------------------------");
            System.out.println("Please,enter your choice");
            ch=Integer.parseInt(br.readLine());
            System.out.println("---------------------------------------------------");
            switch(ch)
            {
                case 1:
                create(head);
                break;
                case 12:
                disp(head);
                break;
                case 2:
                insertbeg();
                break;
                case 3:
                insertlast();
                break;
                case 4:
                insertmid();
                break;
                case 5:
                delbeg();
                break;
                case 6:
                delend();
                break;
                case 7:
                delmid();
                break;
                case 8:
                reverse();
                break;
                case 9:
                merge();
                break;
                case 10:
                split();
                break;
                case 11:
                sum();
                break;
            }
        }while(ch<=12);
    }

    void reverse()
    { node lp=null,nptr;
        save=null;
        start=head.link;
        int n=size/2;
        for (int i=1;i<=n;i++)
        {save=nptr=start;
            while(nptr!=lp)
            {
                save=nptr;
                nptr=nptr.link;
            }
            lp=save;
            int tmp=start.data;
            start.data=lp.data;
            lp.data=tmp;
            start=start.link;
        }
    }

    void create(node head)throws IOException
    {
        start=head;
        System.out.println("enter the no. of nodes initially");
        size=Integer.parseInt(br.readLine());
        for (int i=1;i<=size;i++)
        {
            System.out.println("enter the no");
            int no=Integer.parseInt(br.readLine());
            start.link=new node(no,null);
            start=start.link;
        }
    }

    void disp(node head)
    {start=head.link;
        do
        {
            System.out.println(start.data);
            start=start.link;
        }
        while(start.link!=null);
        System.out.println(start.data);
    }

    void insertbeg()throws IOException
    {
        start=head.link;
        System.out.println("enter the no");
        int no=Integer.parseInt(br.readLine());
        node beg=new node(no,null);
        beg.link=start;
        head.link=beg;
    }

    void insertlast()throws IOException
    {
        start=head.link;
        System.out.println("enter the no");
        int no=Integer.parseInt(br.readLine());
        node last=new node(no,null);
        if (start==null)
            System.out.println("empty node");
        else
            do
            {
                start=start.link;
            }while(start.link!=null);
        start.link=last;
        last.link=null;
    }

    void insertmid()throws IOException
    {
        start=head.link;
        System.out.println("enter the no");
        int no=Integer.parseInt(br.readLine());
        System.out.println("enter the position no. where it has to be inserted");
        int p=Integer.parseInt(br.readLine());
        int ct=0;
        node mid=new node(no,null);
        if (start==null)
            System.out.println("empty node");
        else
            do
            { prv=start;
                start=start.link;
                ct=ct+1;
                if (ct==p-1)
                    break;
            }while(start.link!=null);
        prv.link=mid;
        mid.link=start;
    }

    void delbeg()
    {head=head.link;}

    void delend()
    {
        node prv;
        start =head.link;
        do
        { prv=start;System.out.println(prv.data);
            start=start.link;
        }
        while(start.link!=null);
        prv.link=null;
    }

    void delmid()throws IOException
    {start=head.link;
        System.out.println("enter the position no. where it has to be deleted");
        int p=Integer.parseInt(br.readLine());
        int ct=0;
        do
        { prv=start;
            start=start.link;
            ct=ct+1;
            if (ct==p-1)
                break;
        }while(start.link!=null);
        prv.link=start.link;
    }

    void split()throws IOException
    {int ct=0;
        System.out.println("Enter the position no. for spliting:");
        int p=Integer.parseInt(br.readLine());
        start=head.link;
        do
        { prv=start;
            start=start.link;
            ct=ct+1;
            if (ct==p-1)
                break;
        }while(start.link!=null);
        node h1=new node();
        h1.link=start.link;
        System.out.println(start.link.data);
        start.link=null;
        System.out.println("Content of first list");
        disp(head);
        System.out.println("Content of 2nd list");
        disp(h1);
    }

    void merge()throws IOException
    {
        System.out.println("create the 2nd list");
        node h2=new node();
        create(h2);
        disp(h2);
        start=head.link;
        do
        {
            start=start.link;
        }
        while(start.link!=null);
        start.link=h2.link;
        System.out.println("merged list\n");
        disp(head);
    }

    void sum()
    {int s=0;
        start=head.link;
        do
        { s+=start.data;
            start=start.link;
        }
        while(start.link!=null);
        s+=start.data;
        System.out.println("sum of all the elements in the list"+s);
    }
}