package Geeks.dp;

import java.io.*;
import java.util.*;

/*
Binomial Coefficient : C(n,k) => ( 1+X )^n의 X^k의 계수를 의미한다.
 */

public class BinomialCoefficient {
    // Recursive Way
    // C(n, k) = C(n-1, k-1) + C(n-1, k)
    // C(n, 0) = C(n, n) = 1
    static int binomialCoeff_recur(int n, int k){
        if( k == 0 || k == n)
            return 1;

        return binomialCoeff_recur(n-1, k-1) + binomialCoeff_recur(n-1, k);
    }

    // Iterative way
    // Calculate value of Coeff in bottom up manner
    // Time Complexity of this algorithm is O(n*k)
    static int binomialCoeff_iter(int n, int k){
        int[][] coeff = new int[n+1][n+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<= min(i, k); j++){
                if(j == 0 || j == i)
                    coeff[i][j] = 1;
                else
                    coeff[i][j] = coeff[i-1][j-1] + coeff[i-1][j];
            }
        }

        return coeff[n][k];
    }

    static int min(int a, int b){
        return (a < b) ? a : b;
    }

    // Optimized way of DP
    static int binomialCoeff_Optimal(int n, int k){
        int[] coeff = new int[k+1];

        coeff[0] = 1;

        for(int i=1; i<=n; i++){
            for(int j=min(i, k); j>0; j--)
                coeff[j] = coeff[j] + coeff[j-1];
        }

        return coeff[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n,k;

        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int ans = binomialCoeff_recur(n, k);
        int ans2 = binomialCoeff_iter(n, k);

        out.write("Binomial Coeff Recur result is ("+ n +","+ k +") is " + ans + "\n");
        out.write("Binomial Coeff Iter result is ("+ n +","+ k +") is " + ans2);
        out.flush();
        in.close();
        out.close();
    }
}
