package DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N13549 {
    static int N;
    static int K;
    static boolean[] chk;
    static int[] dx = {-1, 1, 2};
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        chk = new boolean[100001];
        dist = new int[100001];
        int time = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        chk[N] = true;

        int cnt = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int cur = q.poll();

            if(cur == K){
                cnt = Math.min(cnt, dist[K]);
            }
            for(int i=0; i<3; i++){
                int nx;
                if(i == 2)
                    nx = cur * dx[i];
                else
                    nx = cur + dx[i];

                if(nx < 0 || nx > K ) continue;
                if(chk[nx]) continue;

                if(i != 2)
                    dist[nx] = dist[cur]+1;
                chk[nx] = true;
                q.offer(nx);
            }
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
