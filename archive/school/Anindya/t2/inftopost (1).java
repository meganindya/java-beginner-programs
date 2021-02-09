class inftopost
{
    void main(String x)
    {
        int l=x.length();String res="";
        char st=new char[l];
        int ct=0;
        for(int i=0;i<l;i++)
        {
            char ch=x.charAt(i);
            if(character.isLetter(ch))
            res=res+ch;
            if(isoperator())
            {
                int r1=precedence(ch);
                char sc=stack[top];
                if(sc=='+'||sc=='-'||sc=='*'||sc=='/'||sc=='^')
                int r2=precedence(sc);
                if(r2>r1)
                while(st.top-1=='(')
                {
                    res=res+st.pop();
                }
                else
                st.push(ch);
            }
            if(ch==')')
            while(st.top!='(')
            {
                res=res+st.pop();
            }
        }
    }
    int precedence(char ch)
    {
        int p=0;
        switch(ch)
        {
            case '-':
            p=5;
            break;
            case '+':
            p=4;
            break;
            case '*':
            p=3;
            break;
            case '/':
            p=2;
            break;
            case '^':
            p=1;
            break;
        }
        return p;
    }
    boolean isoperator(char c)
    {
        if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^')
        return true;
    }
}