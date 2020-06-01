package BOJ.graph;

import java.io.*;
import java.util.*;

public class n2606 {
    static final int INF = 99999;

    static int floydWarshall(int[][] graph){
        int len = graph.length;

        int[][] dist = new int[len][len];

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                dist[i][j] = graph[i][j];
            }
        }

        for(int k=0; k<len; k++){
            for(int i=0; i<len; i++){
                for(int j=0; j<len; j++){
                    if(i == j)continue;
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<len; i++){
            if(dist[0][i] != INF)
                ++cnt;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int V = Integer.parseInt(in.readLine());
        int[][] graph = new int[V][V];

        int pair = Integer.parseInt(in.readLine());

        for(int i=0; i<V; i++)
            Arrays.fill(graph[i], INF);

        for(int i=0; i<pair; i++){
            st = new StringTokenizer(in.readLine());
            int v = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            graph[v][e] = 1;
            graph[e][v] = 1;
        }

        out.write(floydWarshall(graph)+"\n");
        out.flush();
        in.close();
        out.close();
    }
}
