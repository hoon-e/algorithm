package BOJ.sort;

import java.io.*;
import java.util.*;

public class n5544 {
    static class score {
        int idx;
        int score;

        score(int idx) {
            this.idx = idx;
            this.score = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(in.readLine());

        score[] scores = new score[N];

        for(int i=0; i<N; i++)
            scores[i] = new score(i+1);

        int matches = N*(N-1)/2;
        int[] info = new int[4];
        int[] deg = new int[N+1];

        for(int i=0; i<matches; i++){
            st = new StringTokenizer(in.readLine());

            for(int j=0; j<4; j++) {
                info[j] = Integer.parseInt(st.nextToken());
            }

            if(info[2] > info[3]){
                scores[info[0]-1].score += 3;
            }else if(info[2] == info[3]){
                scores[info[0]-1].score += 1;
                scores[info[1]-1].score += 1;
            }else{
                scores[info[1]-1].score += 3;
            }
        }

        Arrays.sort(scores, (s1, s2) -> {
            return s2.score - s1.score;
        });

        int sc = Integer.MAX_VALUE;
        int dg = 0;
        int cnt = 1;
        for(int i=0; i<N; i++){
            if(sc > scores[i].score){
                dg += cnt;
                deg[scores[i].idx] = dg;
                sc = scores[i].score;
                cnt = 1;
            }else if(sc == scores[i].score){
                deg[scores[i].idx] = dg;
                cnt += 1;
                sc = scores[i].score;
            }
        }

        for(int i=1; i<=N; i++)
            out.write(deg[i]+"\n");

        out.flush();
        in.close();
        out.close();
    }
}
