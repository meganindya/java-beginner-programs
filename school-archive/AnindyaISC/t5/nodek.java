class nodek
{
    static double power(int a,int b){
        return Math.pow(a,b);
    }
    static float sqr(int a){
        return (((float)Math.sqrt(a)));
    }
    static double ang(double a1,double b1){
        try{
            return (double)((float)(a1/b1));
        }
        catch(Exception e){
            return 5.52;
        }
    }
    static void multi(double a1,double b1){
        String opr1=Double.toString(a1*b1);
        double temp=Double.parseDouble(opr1);
        int exv=0;
        System.out.println(opr1);
        for(int i=0;i<opr1.length();i++){
            //System.out.println(i+"|"+opr1.charAt(i));
            if(opr1.charAt(i)=='E'){
                exv=Integer.parseInt(opr1.substring(i+1));
                opr1=opr1.substring(0, i);
            }
        }
        System.out.print(opr1+"|"+exv);
    }
}