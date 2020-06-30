package RE.dp;

import java.io.*;
import java.util.*;

public class n1003 {
    static int T;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(in.readLine());

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(in.readLine());

            int zero = 1;
            int one = 0;
            int sum = 1;

            if ( n != 0 ) {
                for ( int j = 1; j <= n; j++ ) {
                    zero = one;
                    one = sum;
                    sum = zero + one;
                }
            }
            out.write(zero + " " + one + "\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
