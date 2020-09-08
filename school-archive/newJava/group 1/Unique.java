import java.util.Scanner;
public class Unique
{
boolean isU(int y)
{
int d[] = new int[5];
int t = 0;
boolean U = true;
while(y > 0)
{
d[t++] = y%10;
y = y/10;
}
for(int k = 0; k < t; k++)
{
for(int h = k+1; h < t; h++)
{
if(d[k] == d[h])
{
U = false;
break;
}
}
}
return U;
}
public static void main()
{
int m, n, i;
int r;
int x = 0;
boolean W;
Unique O = new Unique();
Scanner S = new Scanner(System.in);
System.out.println("Input:");
System.out.println("m = ");
m = S.nextInt();
System.out.println("n = ");
n = S.nextInt();
if(m >= n)
System.out.println("ERROR.");
else
{
int E[] = new int[n-m];
for(i = m+1; i < n+1; i++)
{
W = O.isU(i);
if (W)
E[x++] = i;
}
System.out.println("OUTPUT:");
System.out.println("THE UNIQUE-DIGIT INTEGERS ARE:");
System.out.println();
for(r = 0; r < x-1; r++)
System.out.print(E[r] + ", ");
System.out.println(E[x-1] + ".");
}
}
}