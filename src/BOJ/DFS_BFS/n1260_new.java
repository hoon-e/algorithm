package BOJ.DFS_BFS;

import java.io.*;
import java.util.*;

public class n1260_new {
    static int N;
    static int M;
    static int V;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb;
    static boolean[] vst;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        sb = new StringBuilder();

        for(int i=0; i<=N; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i=1; i<=N; i++)
            graph[i].sort(Comparator.comparingInt(n -> n));

        vst = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        vst = new boolean[N+1];
        bfs(V);

        out.write(sb.toString());
        out.flush();
        in.close();
        out.close();
    }

    static void bfs(int V){
        Queue<Integer> queue = new LinkedList<>();

        vst[V] = true;
        queue.offer(V);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for(int next : graph[cur]){
                if(!vst[next]){
                    vst[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    static void dfs(int V){
        vst[V] = true;
        sb.append(V).append(" ");

        for(int next : graph[V]){
            if(!vst[next]){
                vst[next] = true;
                dfs(next);
            }
        }
    }
}
