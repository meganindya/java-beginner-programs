package Games_and_Puzzles;
import java.io.*;
import java.util.*;
import java.lang.*;
public class sudoku {
    static int recurCalls = 0;     
    public static void main( String [ ] args )
    {
        String str;
        BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
        int line = 1;
        System.out.print( "Enter a file name containing a Suduko puzzle: " );    
	   try {
	       str = in.readLine( );
	       int[][] matrix = parseProblem(str);
	       writeMatrix(matrix);
	       if (solve(0,matrix))    // solves in place
		     writeMatrix(matrix);
	       else
		     System.out.println("NONE");
	      } catch( IOException e ) { 
	        System.err.println( "Error: " + e );
	    }
        
	   System.out.println("Number of recursive calls = " + recurCalls);
       System.out.println("Goodbye.");
    }
    static int nextPosition(int p) {
	 int j = p & 15;          
	 if (j < 8) return p+1;   
	 int i = p >> 4;          
	 if (i == 8) return -1;   
	 return (i+1)<< 4; 
    }
    static boolean solve(int p, int[][] cells) {
	 recurCalls++;
	 if (p == -1) return true; 
	 if (p == -2) return false;
	 int j = p & 15;  
	 int i = p >> 4;  
     if (cells[i][j] != 0)  // skip filled cells
            return solve(nextPosition(p),cells);

     for (int val = 1; val <= 9; ++val) {
            if (legal(i,j,val,cells)) {
                cells[i][j] = val;
                if (solve(nextPosition(p),cells))
                    return true;
            }
        }
        cells[i][j] = 0; 
        return false;
    }
    static boolean legal(int i, int j, int val, int[][] cells) {
	    for (int k = 0; k < 9; ++k)  
            if (val == cells[k][j])
                return false;
        for (int k = 0; k < 9; ++k) 
            if (val == cells[i][k])
                return false;
        int boxRowOffset = (i / 3)*3;
        int boxColOffset = (j / 3)*3;
        for (int k = 0; k < 3; ++k) 
            for (int m = 0; m < 3; ++m)
                if (val == cells[boxRowOffset+k][boxColOffset+m])
                    return false;
        return true; 
    }
    static int[][] parseProblem(String filename) {
        int[][] puzzle = new int[9][9];
	   try {
	      Scanner sc = new Scanner(new File(filename));
	      int i = 0; 
       	while(sc.hasNext()){
		     int j = 0;
		    String line = sc.nextLine();   

		for( int x = 0; x < line.length(); x++) 
		    if( Character.isDigit(line.charAt(x)) ) {
			puzzle[i][j] = Character.getNumericValue(line.charAt(x)); 
			j++;
		    }
		if (i == 9) break;
		i++; 
	    }
	   } catch(FileNotFoundException e ) { 
	       System.err.println( "Error: " + e );
	   }
        return puzzle;
    }
    static void writeMatrix(int[][] solution) {
        System.out.println("The puzzle and the solution - ");
        for (int i = 0; i < 9; ++i) {
            if (i % 3 == 0)
                System.out.println(" -----------------------");
            for (int j = 0; j < 9; ++j) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print(solution[i][j] == 0
                                 ? " "
                                 : Integer.toString(solution[i][j]));
                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }
}
/*
 sudoku.main({ });
Enter a file name containing a Suduko puzzle: puzzle1.txt
Solutions-
 -----------------------
|   8   | 4   2 |   6   |
|   3 4 |       | 9 1   |
| 9 6   |       |   8 4 |
 -----------------------
|       | 2 1 6 |       |
|       |       |       |
|       | 3 5 7 |       |
 -----------------------
| 8 4   |       |   7 5 |
|   2 6 |       | 1 3   |
|   9   | 7   1 |   4   |
 -----------------------
Solutions-
 -----------------------
| 1 8 7 | 4 9 2 | 5 6 3 |
| 5 3 4 | 6 7 8 | 9 1 2 |
| 9 6 2 | 1 3 5 | 7 8 4 |
 -----------------------
| 4 5 8 | 2 1 6 | 3 9 7 |
| 2 7 3 | 8 4 9 | 6 5 1 |
| 6 1 9 | 3 5 7 | 4 2 8 |
 -----------------------
| 8 4 1 | 9 6 3 | 2 7 5 |
| 7 2 6 | 5 8 4 | 1 3 9 |
| 3 9 5 | 7 2 1 | 8 4 6 |
 -----------------------
Number of recursive calls = 9320
Goodbye.
sudoku.main({ });
Enter a file name containing a Suduko puzzle: puzzle2.txt
Solution-
 -----------------------
|   6   | 7   9 |     3 |
|     2 |     8 | 5     |
|       |   4 5 |       |
 -----------------------
|     5 |     4 |   6   |
|   3 6 |       | 4 7   |
|   8   | 5     | 2     |
 -----------------------
|       | 1 5   |       |
|     1 | 4     | 9     |
| 6     | 8   7 |   1   |
 -----------------------
Solution-
 -----------------------
| 5 6 8 | 7 2 9 | 1 4 3 |
| 7 4 2 | 3 1 8 | 5 9 6 |
| 9 1 3 | 6 4 5 | 7 2 8 |
 -----------------------
| 1 7 5 | 2 3 4 | 8 6 9 |
| 2 3 6 | 9 8 1 | 4 7 5 |
| 4 8 9 | 5 7 6 | 2 3 1 |
 -----------------------
| 3 9 7 | 1 5 2 | 6 8 4 |
| 8 2 1 | 4 6 3 | 9 5 7 |
| 6 5 4 | 8 9 7 | 3 1 2 |
 -----------------------
Number of recursive calls = 18108
Goodbye.
sudoku.main({ });
Enter a file name containing a Suduko puzzle: puzzle3.txt
Solution-
 -----------------------
| 8     |       |       |
|     3 | 6     |       |
|   7   |   9   | 2     |
 -----------------------
|   5   |     7 |       |
|       |   4 5 | 7     |
|       | 1     |   3   |
 -----------------------
|     1 |       |   6 8 |
|     8 | 5     |   1   |
|   9   |       | 4     |
 -----------------------
Solution-
 -----------------------
| 8 1 2 | 7 5 3 | 6 4 9 |
| 9 4 3 | 6 8 2 | 1 7 5 |
| 6 7 5 | 4 9 1 | 2 8 3 |
 -----------------------
| 1 5 4 | 2 3 7 | 8 9 6 |
| 3 6 9 | 8 4 5 | 7 2 1 |
| 2 8 7 | 1 6 9 | 5 3 4 |
 -----------------------
| 5 2 1 | 9 7 4 | 3 6 8 |
| 4 3 8 | 5 2 6 | 9 1 7 |
| 7 9 6 | 3 1 8 | 4 5 2 |
 -----------------------
Number of recursive calls = 72097
Goodbye.
*/
