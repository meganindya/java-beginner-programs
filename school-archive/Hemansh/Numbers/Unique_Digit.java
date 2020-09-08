package Numbers;
import java.io.*;
class Unique_Digit
{
    int k,x,i,j,m,n,c,arr[],index;
    BufferedReader br;
    public static void main(String args[])throws IOException
    {
        Unique_Digit ob=new Unique_Digit();
        ob.take();
        ob.show();
    }

    Unique_Digit()
    {
        br=new BufferedReader(new InputStreamReader(System.in));
        arr=new int[1000];
        c=0;
        index=0;
    }

    public void take()throws IOException
    {
        while(true)
        {
            System.out.println("Enter the Lower range:");
            m=Integer.parseInt(br.readLine().trim());
            System.out.println("Enter the Upper range:");
            n=Integer.parseInt(br.readLine().trim());
            if(m< n)
                break;
        }
    }

    void show ()
    {
        System.out.println("The unique digit integers are:");
        for(i=m;i<=n;i++)
        {
            index=0;
            for(j=i;j> 0;j=j/10)
            {
                x=j%10;
                for(k=0;k< index;k++)
                {
                    if (arr[k]==x)
                        break;
                }
                if(k< index)
                    break;
                else
                    arr[index++]=x;
            }
            if (j==0)
            {
                c++;
                System.out.print(" "+i);
            }
        }

        System.out.println("\nFequency of unique digit integers is :"+ c);
    }
}
/*
-Enter the Lower range:
100
Enter the Upper range:
120
The unique digit integers are:
102 103 104 105 106 107 108 109 120
Fequency of unique digit integers is :9

-Enter the Lower range:
150
Enter the Upper range:
200
The unique digit integers are:
150 152 153 154 156 157 158 159 160 162 163 164 165 167 168 169 170 172 173 174 175 176 178 179 180 182 183 184 185 186 187 189 190 192 193 194 195 196 197 198
Fequency of unique digit integers is :40

-Enter the Lower range:
1101
Enter the Upper range:
1130
The unique digit integers are:

Fequency of unique digit integers is :0

-Enter the Lower range:
1204
Enter the Upper range:
1230
The unique digit integers are:
1204 1205 1206 1207 1208 1209 1230
Fequency of unique digit integers is :7
 */ 