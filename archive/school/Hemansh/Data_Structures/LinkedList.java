package Data_Structures;
import java.io.*;
class LinkedList
{
    void main() throws IOException
    {
        int i, ch = 0, d, pos;
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("Let us create the list");
        System.out.println("List size?");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the data");
        for(i=1;i<=n;i++)
        {
            d = Integer.parseInt(br.readLine());
            addatbeg(d);
        }
        System.out.println("Operations - ");
        while(ch!=5)
        {
          System.out.println("1. Display");  
          System.out.println("2. Add element at a position");
          System.out.println("3. Delete element from a position");
          System.out.println("4. Search for an element");
          System.out.println("5. Exit");
          ch = Integer.parseInt(br.readLine());
          switch(ch)
          {
              case 1:
              disp();
              break;
              case 2:
              System.out.println("Enter element");
              d = Integer.parseInt(br.readLine());
              System.out.println("Enter position");
              pos = Integer.parseInt(br.readLine());
              if(pos==1)
              addatbeg(d);
              else
              insertnode(d,pos);
              disp();
              break;
              case 3:
              System.out.println("Enter position");
              pos = Integer.parseInt(br.readLine());
              if(pos==1)
              deletefirst();
              else
              deletenode(pos);
              disp();
              break;
              case 4:
              System.out.println("Enter element");
              d = Integer.parseInt(br.readLine());
              searchNode(d);
              break;
              case 5:
              System.out.println("Have a nice day");
              System.exit(0);
              break;
              default:
              System.out.println("Try Again");
              break;
            }
        }
    }
    Node header;
    LinkedList()
    {
        header = null;
    }
    void createfirst(int d)
    {
        Node newnode= new Node(d);
        header = newnode;
    }
    void addatbeg(int d)
    {
        Node newnode = new Node(d);
        newnode.link = header;
        header = newnode;
    }
    void deletefirst()
    {
        Node temp = header;
        System.out.println("Data to be deleted - " + temp.link + ", " + temp.data);
        while(temp!=null)
        {
            temp = temp.link;
        }
    }
    void searchNode(int item)
    {
        Node temp = header;
        while(temp.link!=null)
        {
            if(item==temp.data)
            {
                System.out.println("Found " + temp.data + " at " + temp);
                return;
            }
            temp=temp.link;
        }
        System.out.println("Not Found");
    }       
    void insertnode(int d, int pos)
    {
        int i;
        Node newnode = new Node(d);
        Node temp = header;
        for(i=1;i<pos-1;i++)
        temp=temp.link;
        newnode.link=temp.link;
        temp.link=newnode;
    }
    void deletenode(int pos)
    {
        Node temp = header;
        int i;
        for(i=1;i<pos-1;i++)
        temp=temp.link;
        System.out.println(" To be deleted " + temp.link + ", " + temp.link.data);
        temp.link=temp.link.link;
    }
    void insertAscending(int d)
    {
        Node temp = header;
        int i;
        for(i=1;temp.data<d;i++)
        {
            temp=temp.link;
            if(temp.link==null)
            break;
        }
        if(i==1)
        addatbeg(d);
        else
        insertnode(i,d);
    }
    void disp()
    {
        System.out.println();
        Node temp = header;
        System.out.println(header);
        while(temp!=null)
        {
            System.out.println(temp.data+", "+temp.link);
            temp=temp.link;
        }
        System.out.println();
    }
}
class Node
{
    int data;
    Node link;
    Node(int d)
    {
       data = d;
       link = null;
    }
}
