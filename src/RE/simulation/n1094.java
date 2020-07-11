package RE.simulation;

import java.io.*;
import java.util.*;

public class n1094 {
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(in.readLine());

        int cnt = 0;

        while( X > 0 ) {
            if( X % 2 == 1 ) ++cnt;
            X /= 2;
        }

        out.write(cnt+"");
        out.flush();
        in.close();
        out.close();
    }
}
