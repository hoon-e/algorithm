package BOJ.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드 와샬
public class N1504 {
    static int N;
    static int E;
    static int v1;
    static int v2;
    static int[][] nodes;
    static boolean[][] vst;

    static final int INF = 1_000_000;
    static int min = INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        nodes = new int[N+1][N+1];

        for(int i=1; i<=N; i++)
            Arrays.fill(nodes[i], INF);

        int s, e, d;
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            nodes[s][e] = d;
            nodes[e][s] = d;
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dijkstra1504();

        if(min == INF)
            bw.write("-1");
        else
            bw.write(min+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra1504(){
        vst = new boolean[N+1][N+1];

        // 삼중 포문으로 해결한다.
        for(int i=1; i<=N; i++){ // 출발 하는 노드
            for(int j=1; j<=N; j++){ // 도착하는 노드
                for(int k=1; k<=N; k++){
                    if(k == v1) continue;
                    nodes[j][k] = Math.min(nodes[j][i] + nodes[i][k], nodes[j][k]);
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                System.out.print(nodes[i][j] + " " );
            }
            System.out.println();
        }

        return 0;
    }
}
