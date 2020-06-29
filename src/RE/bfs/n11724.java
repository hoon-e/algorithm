package RE.bfs;

import java.io.*;
import java.util.*;

public class n11724 {
    static int N;
    static int M;
    static ArrayList<Integer>[] graph;
    static boolean[] vst;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i=0; i<=N; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        vst = new boolean[N+1];
        int cnt = 0;

        for(int i=1; i<=N; i++){
            if(!vst[i]){
                ++cnt;
                dfs(i);
            }
        }

        out.write(cnt+"");
        out.flush();
        in.close();
        out.close();
    }

    static void dfs(int v){
        vst[v] = true;

        for(int next : graph[v]){
            if(!vst[next])
                dfs(next);
        }
    }
}
