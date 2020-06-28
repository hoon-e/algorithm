package RE.bfs;

import java.io.*;
import java.util.*;

public class n1697 {
    static class moving {
        int x;
        int time;

        moving(int x, int time){
            this.x = x;
            this.time = time;
        }
    }

    static int N;
    static int K;
    static boolean[] vst = new boolean[100001];
    static final int END = 100_001;
    static int[] dx = {-1, 1, 2};

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<moving> way = new LinkedList<>();
        way.offer(new moving(N, 0));
        vst[N] = true;

        int time = 100_000_001;
        while(!way.isEmpty()){
            moving cur = way.poll();

            if(cur.x == K){
                time = Math.min(time, cur.time);
            }

            for(int i = 0; i < 3; i++){
                int nx;
                if(i == 2){
                    nx = cur.x * 2;
                }else{
                    nx = cur.x + dx[i];
                }

                if(nx < 0 || nx >= END) continue;
                if(vst[nx]) continue;
                vst[nx] = true;
                way.offer(new moving(nx, cur.time+1));
            }
        }

        out.write(time+"");
        out.flush();
        in.close();
        out.close();
    }
}