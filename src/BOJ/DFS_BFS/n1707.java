package BOJ.DFS_BFS;

import java.io.*;
import java.util.*;

/*
정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지않도록 분할 할 수 있다.
 */

public class n1707 {
    static ArrayList<Integer>[] graph;
    static int[] state;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(in.readLine());

        while(tc-- > 0){
            st = new StringTokenizer(in.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];

            for(int i=1; i<=V; i++)
                graph[i] = new ArrayList<>();

            for(int i=0; i<E; i++){
                st = new StringTokenizer(in.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            // 방문의 상태는 세 가지이다.
            // 0 : 아직 방문하지 않은 경우
            // 1 : 1 그룹에 방문한 경우
            // 2 : 2 그룹에 방문한 경우
            state = new int[V+1];
            boolean flag = true;

            // 아직 방문하지 않은 경우, 1 그룹으로 먼저 방문한다.
            for(int i=1; i<=V; i++){
                if(state[i] == 0)
                    dfs(i, 1);
            }

            // 해당 정점을 순회하며, 인접해있는 정점이 현재 정점과 타입이 같다면
            // 이분 그래프가 될 수 없다.
            for(int i=1; i<=V; i++){
                for(int next : graph[i]){
                    if(state[i] == state[next]){
                        flag = false;
                        break;
                    }
                }
            }

            if(flag)
                out.write("YES\n");
            else
                out.write("NO\n");
        }

        out.flush();
        in.close();
        out.close();
    }

    static void dfs(int u, int type){
        // 방문체크를 해당 타입으로 해준다.
        state[u] = type;

        // 인접해있는 정점은 지금과는 다른 type으로 들어가야한다.
        for(int next : graph[u]){
            if(state[next] == 0)
                dfs(next, 3 - type);
        }
    }
}