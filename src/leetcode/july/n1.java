package leetcode.july;

import java.io.*;
import java.util.*;

public class n1 {
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int k = 1;
        int row = 0;

        while( k <= n ){
            n -= (k++);
            ++row;
        }

        out.write(row+"");
        out.flush();
        in.close();
        out.close();
    }
}
