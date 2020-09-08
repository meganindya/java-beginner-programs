import java.util.*;
class recti
{
    Scanner sc=new Scanner(System.in);char angle='D';
    void main(){
        System.out.print("Enter expression : ");
        String s=sc.nextLine();int brc=0;
        if((s.indexOf("sin")+s.indexOf("cos")+s.indexOf("tan"))!=-3){
            System.out.print("Enter angle convention (D / R / G) : ");
            angle=sc.next().charAt(0);
            angle=Character.toUpperCase(angle);
        }
        while(s.indexOf("(-)")!=-1){
            s=s.substring(0,s.indexOf("(-)"))+"#"+s.substring(s.indexOf("(-)")+3);
        }
        int tpr=0;s=" "+s+" ";
        while(((tpr=s.indexOf("sin",tpr))!=-1)||((tpr=s.indexOf("cos",tpr))!=-1)||((tpr=s.indexOf("tan",tpr))!=-1)||((tpr=s.indexOf("log",tpr))!=-1)||((tpr=s.indexOf("ln",tpr))!=-1)){
            char tpc=s.charAt(tpr-1);tpr++;
            if(tpc!='+' && tpc!='-' && tpc!='/' && tpc!='*' && tpc!='^' && tpc!='(' && tpc!='#')
                s=s.substring(0,tpr)+"*"+s.substring(tpr);
        }
        s=s.trim();
        if(checkERROR(s)==0){
            try{
                s=" ("+s+") ";
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)=='(')    brc++;
                }
                while(brc!=0){
                    int start=0,end=0;
                    qui:
                    for(int i=0;i<s.length();i++){
                        if(s.charAt(i)=='('){
                            start=i;end=i;
                            do{
                                if(s.charAt(end)=='(')  start=end;
                                end++;
                            }while(s.charAt(end)!=')');
                            String result=furnish(s.substring(start+1,end));
                            result=result.trim();
                            if(s.charAt(start-1)>47 && s.charAt(start-1)<58)    result="*"+result;
                            if(s.charAt(end+1)>47 && s.charAt(end+1)<58)        result=result+"*";
                            s=s.substring(0,start)+result+s.substring(end+1);
                            brc--;
                            break qui;
                        }
                    }
                }
                s=s.trim();
                char tte[]=s.toCharArray();
                for(int i=0;i<tte.length;i++){
                    if(tte[i]=='#') tte[i]='-';
                }
                s=new String(tte);
                if(s.equals("NaN")||s.equals("Infinity")||Double.parseDouble(s)==Double.MAX_VALUE) System.out.print("Math ERROR");
                else                System.out.print(s);
            }catch(Exception e){
                System.out.println("Syntax ERROR");
            }
        }
        else{
            if(checkERROR(s)==1)       System.out.println("Syntax ERROR");
            else if(checkERROR(s)==2)  System.out.println("Math ERROR");
        }
    }
    String furnish(String s){
        int opu=0,opb=0;
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if((x<48 || x>57) && (x!='(' && x!=')') && x!='.' && x!='#'){
                if(x=='!')                              opu++;
                else if(x=='@')                         opu++;
                else if(x=='√')                         opu++;
                else if(x=='l' && s.charAt(i+1)=='n')   {i+=1;opu++;}
                else if(x=='l' && s.charAt(i+1)=='o')   {i+=2;opu++;}
                else if(x=='P' && s.charAt(i+1)=='o')   {i+=2;opu++;}
                else if(x=='R' && s.charAt(i+1)=='e')   {i+=2;opu++;}
                else if(x=='s' && s.charAt(i+3)=='(')   {i+=2;opu++;}
                else if(x=='s' && s.charAt(i+3)!='(')   {i+=3;opu++;}
                else if(x=='c' && s.charAt(i+3)=='(')   {i+=2;opu++;}
                else if(x=='c' && s.charAt(i+3)!='(')   {i+=3;opu++;}
                else if(x=='t' && s.charAt(i+3)=='(')   {i+=2;opu++;}
                else if(x=='t' && s.charAt(i+3)!='(')   {i+=3;opu++;}
                else opb++;
            }
        }
        s=" "+s+" ";
        while(opu!=0){
            qui:
            for(int i=0;i<s.length();i++){    
                if(s.charAt(i)=='!' || s.charAt(i)=='@'){
                    int k=i-1;String q="";
                    while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                        q=s.charAt(k)+q;k--;
                    }
                    String result=unary(q+s.charAt(i));
                    s=s.substring(0,k+q.length())+result+s.substring(i+1);
                    break qui;
                }
            }
                if(s.indexOf("√")!=-1){
                    int k=s.indexOf("√")+1;String q="";
                    while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                        q+=s.charAt(k);k++;
                    }
                    String result=unary("√"+q);
                    s=s.substring(0,s.indexOf("√"))+result+s.substring(s.indexOf("√")+q.length()+1);
                }
                if(s.indexOf("ln")!=-1){
                    int k=s.indexOf("ln")+2;String q="";
                    while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                        q+=s.charAt(k);k++;
                    }
                    String result=unary("ln"+q);
                    s=s.substring(0,s.indexOf("ln"))+result+s.substring(s.indexOf("ln")+q.length()+2);
                }
                else if(s.indexOf("log")!=-1){
                    int k=s.indexOf("log")+3;String q="";
                    while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                        q+=s.charAt(k);k++;
                    }
                    String result=unary("log"+q);
                    s=s.substring(0,s.indexOf("log"))+result+s.substring(s.indexOf("log")+q.length()+3);
                }
                else if(s.indexOf("sin-")!=-1){
                    int k=s.indexOf("sin-")+4;String q="";
                    while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                        q+=s.charAt(k);k++;
                    }
                    String result=unary("sin-"+q);
                    s=s.substring(0,s.indexOf("sin-"))+result+s.substring(s.indexOf("sin-")+q.length()+4);
                }
                else if(s.indexOf("cos-")!=-1){
                    int k=s.indexOf("cos-")+4;String q="";
                    while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                        q+=s.charAt(k);k++;
                    }
                    String result=unary("cos-"+q);
                    s=s.substring(0,s.indexOf("cos-"))+result+s.substring(s.indexOf("cos-")+q.length()+4);
                }
                else if(s.indexOf("tan-")!=-1){
                    int k=s.indexOf("tan-")+4;String q="";
                    while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                        q+=s.charAt(k);k++;
                    }
                    String result=unary("tan-"+q);
                    s=s.substring(0,s.indexOf("tan-"))+result+s.substring(s.indexOf("tan-")+q.length()+4);
                }
                else if(s.indexOf("sin")!=-1){
                    int k=s.indexOf("sin")+3;String q="";
                    while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                        q+=s.charAt(k);k++;
                    }
                    String result=unary("sin"+q);
                    s=s.substring(0,s.indexOf("sin"))+result+s.substring(s.indexOf("sin")+q.length()+3);
                }
                else if(s.indexOf("cos")!=-1){
                    int k=s.indexOf("cos")+3;String q="";
                    while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                        q+=s.charAt(k);k++;
                    }
                    String result=unary("cos"+q);
                    s=s.substring(0,s.indexOf("cos"))+result+s.substring(s.indexOf("cos")+q.length()+3);
                }
                else if(s.indexOf("tan")!=-1){
                    int k=s.indexOf("tan")+3;String q="";
                    while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                        q+=s.charAt(k);k++;
                    }
                    String result=unary("tan"+q);
                    s=s.substring(0,s.indexOf("tan"))+result+s.substring(s.indexOf("tan")+q.length()+3);
                }
            opu--;
        }
        while(opb!=0){
            char a[][]=new char[s.length()-2][3];
                for(int j=0;j<s.length()-2;j++){
                    String temp=s.substring(j,j+3);
                    a[j][0]=temp.charAt(0);
                    a[j][1]=temp.charAt(1);
                    a[j][2]=temp.charAt(2);
                }
                int max=0;int maxp=0;
                for(int j=0;j<a.length;j++){
                    char x1=a[j][0];
                    char x2=a[j][1];
                    char x3=a[j][2];
                    if(x2=='^'||x2=='/'||x2=='*'||x2=='+'||x2=='-'||x2=='P'||x2=='C'){
                        if((x1>47 && x1<58) && ((x3>47 && x3<58)||x3=='#')){
                           if(precedence(x2)>maxp)  {max=j;maxp=precedence(x2);}
                        }
                    }
                }
                char x1=a[max][0];
                char x2=a[max][1];
                char x3=a[max][2];
                String n1="",n2="";
                int k=max;
                while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                    n1=Character.toString(s.charAt(k))+n1;
                    k--;
                }
                k=max+2;
                while((s.charAt(k)>47 && s.charAt(k)<58)||s.charAt(k)=='.'||s.charAt(k)=='#'){
                    n2=n2+Character.toString(s.charAt(k));
                    k++;
                }
                String result=binary(n1+Character.toString(x2)+n2);
                s=s.substring(0,max-n1.length()+1)+result+s.substring(max+2+n2.length());
                opb--;
        }
        return s;
    }
    String unary(String a){
        a+=" ";
        double b=0,b1=Double.MAX_VALUE,b2=Double.MAX_VALUE;String op="";
        qui:
        for(int i=0;i<a.length();i++){
            char x=a.charAt(i);
            if((x>47 && x<58)||x=='#'){
                int cod=i;String q="";
                while((a.charAt(cod)>47 && a.charAt(cod)<58)||a.charAt(cod)=='.'||a.charAt(cod)==','||a.charAt(cod)=='#'){
                    q+=Character.toString(a.charAt(cod));
                    cod++;
                }
                if(a.substring(i+q.length()).equals(" ")) op=a.substring(0,i);
                else op=a.substring(i+q.length(),i+q.length()+1);
                for(int j=0;j<q.length();j++){
                    if(q.charAt(j)==','){
                        b1=Double.parseDouble(q.substring(0,j));
                        b2=Double.parseDouble(q.substring(j+1));
                    }
                }
                if(b1==Double.MAX_VALUE){
                    if(q.charAt(0)=='#')    q="-"+q.substring(1);
                    b=Double.parseDouble(q);
                }
                break qui;
            }
        }
        double result;
        switch(op){
            case "!":
                result=1;
                if(b==(int)b)   while(b!=0) {result*=b--;}
                else            result=Double.MAX_VALUE;
                break;
            case "√":
                result=Math.sqrt(b);
                break;
            case "@":
                result=1/b;
                break;
            case "ln":
                result=Math.log(b);
                break;
            case "log":
                result=Math.log10(b);
                break;
            case "sin":
                if      (angle=='D')  result=Math.sin(b*(Math.PI/180));
                else if (angle=='G')  result=Math.sin(b*(Math.PI/200));
                else                  result=Math.sin(b);
                break;
            case "cos":
                if      (angle=='D')  result=Math.cos(b*(Math.PI/180));
                else if (angle=='G')  result=Math.cos(b*(Math.PI/200));
                else                  result=Math.cos(b);
                break;
            case "tan":
                if      (angle=='D')  result=Math.tan(b*(Math.PI/180));
                else if (angle=='G')  result=Math.tan(b*(Math.PI/200));
                else                  result=Math.tan(b);
                break;
            case "sin-":
                try{    
                    if      (angle=='D')  result=Math.asin(b)*(180/Math.PI);
                    else if (angle=='G')  result=Math.asin(b)*(200/Math.PI);
                    else                  result=Math.asin(b);
                }
                catch(Exception e){
                    result=Double.MAX_VALUE;
                }
                break;
            case "cos-":
                try{    
                    if      (angle=='D')  result=Math.acos(b)*(180/Math.PI);
                    else if (angle=='G')  result=Math.acos(b)*(200/Math.PI);
                    else                  result=Math.acos(b);
                }
                catch(Exception e){
                    result=Double.MAX_VALUE;
                }
                break;
            case "tan-":
                if      (angle=='D')  result=Math.atan(b)*(180/Math.PI);
                else if (angle=='G')  result=Math.atan(b)*(200/Math.PI);
                else                  result=Math.atan(b);
                break;
            case "Rec":
                result=b1*Math.cos(b2);
                break;
            case "Pol":
                result=Math.sqrt((b1*b1)+(b2*b2));
                break;
            default:
                result=Double.MAX_VALUE;
        }
        String temp="";
        if(result==(int)result) temp=Integer.toString((int)result);
        else                    temp=Double.toString(result);
        if(result<0)    temp='#'+temp.substring(1);
        return temp;
    }
    String binary(String a){
        a=" "+a+" ";
        String r1="",r2="";char op=0;
        qui:
        for(int i=0;i<a.length();i++){
            char x=a.charAt(i);
            if(x=='^'||x=='/'||x=='*'||x=='+'||x=='-'||x=='C'||x=='P'){
                op=x;
                r1=a.substring(0,i);
                r2=a.substring(i+1);
                break qui;
            }
        }
        double a1=0,a2=0;
        if(r1.charAt(0)=='#')   r1="-"+r1.substring(1);
        if(r2.charAt(0)=='#')   r2="-"+r2.substring(1);
        a1=Double.parseDouble(r1);
        a2=Double.parseDouble(r2);
        double result=0;
        switch(op){
            case '^':
                result=Math.pow(a1,a2);
                break;
            case '/':
                try{    
                    result=a1/a2;
                }
                catch(Exception e){
                    result=Double.MAX_VALUE;
                }
                break;
            case '*':
                result=a1*a2;
                break;
            case '+':
                result=a1+a2;
                break;
            case '-':
                result=a1-a2;
                break;
            case 'C':
                if((a1==(int)a1)&&(a2==(int)a2)&&(a1>=a2)){
                    int s1=1,s2=1,s3=1,a3=(int)(a1-a2);
                    if(a3<0)    result=Double.MAX_VALUE;
                    else{
                        while(a1!=0)    {s1*=a1--;}
                        while(a2!=0)    {s2*=a2--;}
                        while(a3!=0)    {s3*=a3--;}
                        result=s1/(s2*s3);
                    }
                }
                else            result=Double.MAX_VALUE;
                break;
            case 'P':
                if((a1==(int)a1)&&(a2==(int)a2)&&(a1>=a2)){
                    int s1=1,s2=1;a2=a1-a2;
                    while(a1!=0)    {s1*=a1--;}
                    while(a2!=0)    {s2*=a2--;}
                    result=s1/s2;
                }
                else            result=Double.MAX_VALUE;
                break;
            default:
                result=Double.MAX_VALUE;
                break;
        }
        String temp="";
        if(result==(int)result) temp=Integer.toString((int)result);
        else                    temp=Double.toString(result);
        if(result<0)    temp='#'+temp.substring(1);
        return temp;
    }
    int precedence(char x){
        switch(x){
            case '^':
                return 6;
            case 'P':
                return 5;
            case 'C':
                return 5;
            case '/':
                return 4;
            case '*':
                return 3;
            case '+':
                return 2;
            case '-':
                return 1;
            default:
                return 0;
        }
    }
    int checkERROR(String s){
        int bro=0,brc=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')    bro++;
            if(s.charAt(i)==')')    brc++;
        }
        if(bro!=brc)    return 1;
        return 0;
    }
}