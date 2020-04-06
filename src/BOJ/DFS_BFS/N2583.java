package BOJ.DFS_BFS;

import java.io.*;
import java.util.*;

public class N2583 {
    static class coord {
        int x;
        int y;
        coord(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] tile = new int[105][105];
    static boolean[][] visit = new boolean[105][105];
    static int M;
    static int N;
    static int K;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for(int p=a; p<c; p++){
                for(int q=b; q<d; q++)
                    tile[p][q] = -1;
            }
        }

        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visit[i][j] || tile[i][j] == -1) continue;

                visit[i][j] = true;

                Queue<coord> q = new LinkedList<>();
                q.offer(new coord(i,j));
                count++;

                int answer = 1;
                while(!q.isEmpty()){
                    coord cur = q.poll();

                    for(int k=0; k<4; k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if(visit[nx][ny] || tile[nx][ny] == -1 ) continue;
                        visit[nx][ny] = true;
                        q.offer(new coord(nx, ny));
                        answer++;
                    }
                }
                ans.add(answer);
            }
        }

        Collections.sort(ans);
        bw.write(count+"\n");
        for(int a : ans)
            bw.write(a + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}
