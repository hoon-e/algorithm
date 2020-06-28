package RE.backtracking;

import java.io.*;
import java.util.*;

public class n15649 {
    static StringBuilder sb;
    static int[] ans;
    static boolean[] chk;
    static int N;
    static int M;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[M];
        chk = new boolean[N+1];

        sb = new StringBuilder();
        backtracking(0);

        out.write(sb.toString());
        out.flush();
        in.close();
        out.close();
    }

    static void backtracking(int len){
        if(len == M){
            for(int a : ans)
                sb.append(a).append(" ");
            sb.append("\n");

            return;
        }

        for(int i=1; i<=N; i++){
            if(!chk[i]){
                ans[len] = i;
                chk[i] = true;
                backtracking(len+1);
                chk[i] = false;
            }
        }
    }
}
