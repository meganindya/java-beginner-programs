package Data_Structures;
class Binary_Tree
{
    Node header;
    Binary_Tree()
    {
        header=null;
    }
    void input(int a[])
    {
        header = create(a,0,a.length-1,null);
    }
    Node create(int a[],int b, int e, Node pa)
    {
        if(b>e)
        return null;
        int mid=(b+e)/2;
        Node newnd= new Node(a[mid]);
        newnd.p=pa;
        newnd.left=create(a,b,mid-1,newnd);
        newnd.right=create(a,mid+1,e,newnd);
        return newnd;
    }
    int successor(Node k)
    {
        return 0;
    }
    void inorder(Node k)
    {
        if(k==null)
        return;
        inorder(k.left);
        System.out.println(k.data);
        inorder(k.right);
    }
    void main(int a[])
    {
        input(a);
        inorder(header);
    }
}
class Node
{
    Node p, left, right;
    int data;
    Node(int d)
    {
        data=d;
        p=null;
        left=null;
        right=null;
    }
}
