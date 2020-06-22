package BOJ.mathematics;

import java.io.*;
import java.util.*;

public class n1009 {
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(in.readLine());

        for(int i=0; i<tc; i++){
            st = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long s = (a % 10);
            for(int j=0; j<b-1; j++){
                s = ( s * a ) % 10;
            }

            out.write(s == 0 ? (10 + "\n") : (s + "\n"));
        }

        out.flush();
        in.close();
        out.close();
    }
}
