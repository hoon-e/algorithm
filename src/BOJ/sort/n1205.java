package BOJ.sort;

import java.io.*;
import java.util.*;

public class n1205 {
    static int N;
    static int newScore;
    static int P;
    static int[] scores;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        newScore = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if( N == 0 ){
            out.write("1\n");
        }else{
            scores = new int[N];

            st = new StringTokenizer(in.readLine());

            for(int i=0; i<N; i++)
                scores[i] = Integer.parseInt(st.nextToken());

            if(N >= P && scores[N-1] >= newScore)
                out.write("-1\n");
            else {
                int idx = 0;
                int rank = 0;
                int tmpScore = Integer.MAX_VALUE;

                while(idx < N){
                    if(scores[idx] < newScore) break;
                    if(tmpScore > scores[idx]){
                        rank = idx + 1;
                        tmpScore = scores[idx];
                    }
                    ++idx;
                }

                if(tmpScore == newScore)
                    out.write(rank+"");
                else
                    out.write((idx+1)+"");
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
