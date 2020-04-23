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
    static long[][] nodes;

    static final int INF = 800_001;
    static long min = INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        nodes = new long[N+1][N+1];

        //★ 자기 자신으로 오는 길이는 0이다.
        for(int i=1; i<=N; i++) {
            Arrays.fill(nodes[i], INF);
            nodes[i][i] = 0;
        }

        int s, e, d;
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            nodes[s][e] = Math.min(d, nodes[s][e]);
            nodes[e][s] = Math.min(d, nodes[e][s]);
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        min = dijkstra1504();

        if(min == INF)
            bw.write("-1");
        else
            bw.write(min+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static long dijkstra1504(){
        // 플로이드 - 와셜 알고리즘
        for(int k=1; k<=N; k++){ // 출발 하는 노드
            for(int i=1; i<=N; i++){ // 도착하는 노드
                for(int j=1; j<=N; j++){
                    nodes[i][j] = Math.min(nodes[i][k] + nodes[k][j], nodes[i][j]);
                }
            }
        }

        long sum1=(nodes[1][v1] + nodes[v1][v2] + nodes[v2][N]);
        long sum2=(nodes[1][v2] + nodes[v2][v1] + nodes[v1][N]);

        if(sum1 >= INF && sum2 >= INF)
            return INF;
        else
            return Math.min(sum1, sum2);
    }
}
