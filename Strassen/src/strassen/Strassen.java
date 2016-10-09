
package strassen;

import java.util.Scanner;

public class Strassen {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        
        Strassen s = new Strassen();
 
        System.out.println("Enter order n :");
        int N = scan.nextInt();

        System.out.println("Enter 1st matrix");
        int[][] A = new int[N][N];
        
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                A[x][y] = scan.nextInt();
        
        System.out.println("1st matrix");
            for (int x = 0; x < N; x++){
                for (int y = 0; y < N; y++)
                
        System.out.print(A[x][y] +" ");
        System.out.println();
            }
 
        System.out.println("Enter 2nd matrix");
        int[][] B = new int[N][N];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                B[x][y] = scan.nextInt();
        
        System.out.println("2nd matrix");
            for (int x = 0; x < N; x++){
                for (int y = 0; y < N; y++)
                
        System.out.print(B[x][y] +" ");
        System.out.println();
            }
        int[][] C = s.multiply(A, B);
 
        System.out.println("\nProduct of matrices A and  B : ");
        for (int x = 0; x < N; x++){
            for (int y = 0; y < N; y++)
                System.out.print(C[x][y] +" ");
                System.out.println();
        }
    }

    public int[][] multiply(int[][] A, int[][] B){        
        int n = A.length;
        int[][] R = new int[n][n];
        
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];
        
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            
            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);
            
            split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);
 
            int [][] M1 = multiply(add(A11, A22), add(B11, B22));
            int [][] M2 = multiply(add(A21, A22), B11);
            int [][] M3 = multiply(A11, sub(B12, B22));
            int [][] M4 = multiply(A22, sub(B21, B11));
            int [][] M5 = multiply(add(A11, A12), B22);
            int [][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int [][] M7 = multiply(sub(A12, A22), add(B21, B22));
 
            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);
 
 
            join(C11, R, 0 , 0);
            join(C12, R, 0 , n/2);
            join(C21, R, n/2, 0);
            join(C22, R, n/2, n/2);
        }
  
        return R;
    }

    public int[][] sub(int[][] A, int[][] B){
        
        int n = A.length;
        int[][] C = new int[n][n];
        for (int x = 0; x < n; x++)
            for (int y = 0; y < n; y++)
                C[x][y] = A[x][y] - B[x][y];
        return C;
    }
    
    public int[][] add(int[][] A, int[][] B){
        
        int n = A.length;
        int[][] C = new int[n][n];
        for (int x = 0; x < n; x++)
            for (int y = 0; y < n; y++)
                C[x][y] = A[x][y] + B[x][y];
        return C;
    }

    public void split(int[][] P, int[][] C, int xB, int yB){
        for(int x1 = 0, x2 = xB; x1 < C.length; x1++, x2++)
            for(int y1 = 0, y2 = yB; y1 < C.length; y1++, y2++)
                C[x1][y1] = P[x2][y2];
    }

    public void join(int[][] C, int[][] P, int xB, int yB){
        for(int x1 = 0, x2 = xB; x1 < C.length; x1++, x2++)
            for(int y1 = 0, y2 = yB; y1 < C.length; y1++, y2++)
                P[x2][y2] = C[x1][y1];
    }    
    
}
