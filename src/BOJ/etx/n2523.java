package BOJ.etx;

import java.io.*;
import java.util.*;

public class n2523 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();

        for(int i=1; i<=N; i++){
            for(int j=0; j<i; j++)
                System.out.print("*");
            System.out.println();
        }

        for(int i=N-1; i>0; i--){
            for(int j=0; j<i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
