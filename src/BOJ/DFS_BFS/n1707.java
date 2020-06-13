package BOJ.DFS_BFS;

import java.io.*;
import java.util.*;

/*
정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지않도록 분할 할 수 있다.
 */
public class n1707 {
    static ArrayList<Integer>[] graph;
    static boolean[] vst;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(in.readLine());

        for(int i=0; i<tc; i++){
            st = new StringTokenizer(in.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];

            for(int j=0; j<=V; j++)
                graph[j] = new ArrayList<>();

            for(int j=0; j<E; j++){
                st = new StringTokenizer(in.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            int child = 0;

            for(int j=1; j<=V; j++){
                if(graph[j].size() <= 1)
                    ++child;
            }

            out.write( (child >= V/2) ? "YES\n" : "NO\n" );
        }

        out.flush();
        in.close();
        out.close();
    }
}