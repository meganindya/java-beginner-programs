package Games_and_Puzzles;
public class Queens 
{
    static int c = 0;
    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             
               return false;   // same column
            if ((q[i] - q[n]) == (n - i)) 
               return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i))
               return false;   // same minor diagonal
        }
        return true;
    }
    public static void printQueens(int[] q) {
        int N = q.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q[i] == j) 
                   System.out.print("Q ");
                else           
                   System.out.print("# ");
            }
            System.out.println();
        }  
        System.out.println();
    }
    public static void enumerate(int N) {
        int[] a = new int[N];
        enumerate(a, 0);
    }
    public static void enumerate(int[] q, int n) {
        int N = q.length;
        if (n == N)
        {
            printQueens(q);
            c++;
        }
        else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isConsistent(q, n))
                    enumerate(q, n+1);
            }
        }
    }  
    public static void main(int n) {
        c=0;
        int N = n;
        enumerate(N);
        System.out.println("Solns = " + c);
    }
}
/*
Queens.main(4);
# Q # # 
# # # Q 
Q # # # 
# # Q # 

# # Q # 
Q # # # 
# # # Q 
# Q # # 

Queens.main(5);
Q # # # # 
# # Q # # 
# # # # Q 
# Q # # # 
# # # Q # 

Q # # # # 
# # # Q # 
# Q # # # 
# # # # Q 
# # Q # # 

# Q # # # 
# # # Q # 
Q # # # # 
# # Q # # 
# # # # Q 

# Q # # # 
# # # # Q 
# # Q # # 
Q # # # # 
# # # Q # 

# # Q # # 
Q # # # # 
# # # Q # 
# Q # # # 
# # # # Q 

# # Q # # 
# # # # Q 
# Q # # # 
# # # Q # 
Q # # # # 

# # # Q # 
Q # # # # 
# # Q # # 
# # # # Q 
# Q # # # 

# # # Q # 
# Q # # # 
# # # # Q 
# # Q # # 
Q # # # # 

# # # # Q 
# Q # # # 
# # # Q # 
Q # # # # 
# # Q # # 

# # # # Q 
# # Q # # 
Q # # # # 
# # # Q # 
# Q # # # 

Queens.main(6);
# Q # # # # 
# # # Q # # 
# # # # # Q 
Q # # # # # 
# # Q # # # 
# # # # Q # 

# # Q # # # 
# # # # # Q 
# Q # # # # 
# # # # Q # 
Q # # # # # 
# # # Q # # 

# # # Q # # 
Q # # # # # 
# # # # Q # 
# Q # # # # 
# # # # # Q 
# # Q # # # 

# # # # Q # 
# # Q # # # 
Q # # # # # 
# # # # # Q 
# # # Q # # 
# Q # # # # 
 */


