package BOJ.DFS_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N5014 {
    static int F;
    static int S;
    static int G;
    static int[] button = new int[2];
    static boolean[] chk = new boolean[1000001];
    static int[] dist = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        button[0] = Integer.parseInt(st.nextToken());
        button[1] = -1*Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        q.offer(S);
        chk[S] = true;
        boolean flag = true;
        int cnt = Integer.MAX_VALUE;
        dist[S] = 0;

        while(!q.isEmpty()){
            int f = q.poll();

            if(f == G) {
                flag = false;
                cnt = Math.min(cnt, dist[G]);
            }

            for(int i=0; i<2; i++){
                int nxt = f + button[i];
                if(nxt < 1 || nxt > F) continue;
                if(chk[nxt]) continue;

                chk[nxt] = true;
                dist[nxt] = dist[f]+1;
                q.offer(nxt);
            }
        }

        if(flag)
            bw.write("use the stairs\n");
        else
            bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
