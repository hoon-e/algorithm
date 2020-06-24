package BOJ.sort;

import java.io.*;
import java.util.*;

public class n2959 {
    static int[] edge = new int[4];
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());

        for(int i=0; i<4; i++){
            edge[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edge);

        out.write(edge[0] * edge[2] + "\n");
        out.flush();
        in.close();
        out.close();
    }
}
