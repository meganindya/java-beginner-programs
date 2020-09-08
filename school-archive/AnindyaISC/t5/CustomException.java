class NullException extends Exception
{
    int a;
    public NullException(int i)
    {
        a=i;
    }
    public String toString()
    {
        return "Created Null Exception"+a;
    }
}
public class CustomException
{
    public static void Divide(int a,int b)throws NullException
    {   
        int k=a/b;throw new NullException(k);
    }

    public static void main(int i,int j)
    {
        try
        {
            CustomException c=new CustomException();
            c.Divide(i,j);
        }
        catch(Exception e)
        {
            System.out.println("Main CustomException"+e);
        }
        finally
        {   
            System.out.println("Finally Exception");
        }
    }
}