package RE.dp;

import java.io.*;
import java.util.*;

public class n11053 {
    static int N;
    static int[] num;
    static int[] dp;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        num = new int[N];
        dp = new int[N];

        st = new StringTokenizer(in.readLine());

        for(int i=0; i<N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        out.flush();

        in.close();
        out.close();
    }

    static int max(int a, int b){
        return (a > b) ? a : b;
    }
}
