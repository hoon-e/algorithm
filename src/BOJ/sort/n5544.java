package BOJ.sort;

import java.io.*;
import java.util.*;

public class n5544 {
    static class score {
        int idx;
        int score;

        score() {
            this.score = 0;
        }

        score(int idx, int score){
            this.idx = idx;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(in.readLine());

        score[] scores = new score[N];

        for(int i=0; i<N; i++)
            scores[i] = new score();

        int matches = N*(N-1)/2;
        int[] info = new int[4];

        for(int i=0; i<matches; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<4; j++)
                info[i] = Integer.parseInt(st.nextToken());

            if(info[1] > info[3]){
                scores[info[0]] += 3;
            }else if(info[1] == info[3]){
                scores[info[0]] += 1;
                scores[info[2]] += 1;
            }else{
                scores[info[2]] += 3;
            }
        }

        out.flush();
        in.close();
        out.close();
    }
}
