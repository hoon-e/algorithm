package RE.bfs;

import java.io.*;
import java.util.*;

public class n6603 {
    static int K;
    static int[] set;
    static boolean[] chk;
    static StringBuilder sb;
    static int[] lotto = new int[6];

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(in.readLine());

            K = Integer.parseInt(st.nextToken());

            if(K == 0)
                break;

            set = new int[K];
            chk = new boolean[K];

            for(int i=0; i<K; i++)
                set[i] = Integer.parseInt(st.nextToken());

            tracking(0, 0);
            sb.append("\n");
        }

        out.write(sb.toString());
        out.flush();
        in.close();
        out.close();
    }

    static void tracking(int start, int len){
        if(len == 6){
            for(int l : lotto)
                sb.append(l).append(" ");
            sb.append("\n");

            return;
        }

        for(int i=start; i<K; i++){
            if(!chk[i]){
                chk[i] = true;
                lotto[len] = set[i];
                tracking(i + 1, len + 1);
                chk[i] = false;
            }
        }

        return;
    }
}
