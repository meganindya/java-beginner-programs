class arc
{    
    void get_random()
    {
        int rnd[]=new int[20];
        for(int i=0;i<(20);i++)
        {   rnd[i]=(int)(Math.ceil(Math.random()*2938));
            for(int j=0;j<i;j++)
                if(rnd[j]==rnd[i]) i--;
        }
        for(int i=0;i<20;i++)
            System.out.println(rnd[i]);
    }
}