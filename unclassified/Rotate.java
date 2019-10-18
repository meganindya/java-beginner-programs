import java.io.*;

class Rotate {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());
            
            String s = br.readLine();
            
            c = c % n;
            int m = b % n;
            int d = b / n;
            
            Rotate ob = new Rotate();
            s = ob.rotateBy(s.substring(0, c), n % c, d) +
                ob.rotateBy(s.substring(c), c % (n - c), d);
            
            char z[] = s.toCharArray();
            for(int i = 0; i < m; i++)
                ob.swap(z, i, (i + c) % n);
            
            System.out.println(new String(z));
        }
    }
    
    String rotateBy(String s, int c, int n) {
        int r = (n * c) % s.length();
        return s.substring(r) + s.substring(0, r);
    }
    
    void swap(char z[], int a, int b) {
        char temp = z[a];
        z[a] = z[b];
        z[b] = temp;
    }
}