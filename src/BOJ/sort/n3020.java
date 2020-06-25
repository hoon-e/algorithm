package BOJ.sort;

import java.io.*;
import java.util.*;

public class n3020 {
    static int N; // 200,000
    static int H; // 500,000
    static int[] obs;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        obs = new int[N];

        for(int i=0; i<N; i++)
            obs[i] = Integer.parseInt(in.readLine());



        out.flush();
        in.close();
        out.close();
    }
}
