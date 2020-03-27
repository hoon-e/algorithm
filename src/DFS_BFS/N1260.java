package DFS_BFS;

import java.io.*;
import java.util.*;

public class N1260 {
    static ArrayList<ArrayList<Integer>> node;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int idx = Integer.parseInt(st.nextToken());

        node = new ArrayList<>();
        chk = new boolean[N+1];

        for(int i=0; i<=N; i++){
            node.add(new ArrayList<>());
        }

        for(int i=0; i<V; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            node.get(u).add(v);
            node.get(v).add(u);
        }

        for(int i=1; i<=N; i++)
            Collections.sort(node.get(i));

        dfs(idx);
        System.out.println();
        chk = new boolean[N+1];
        bfs(idx);
        br.close();
    }

    static void bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
        chk[idx] = true;

        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.print(temp + " ");
            for(int p : node.get(temp)){
                if(!chk[p]){
                    chk[p] = true;
                    q.offer(p);
                }
            }
        }
    }

    static void dfs(int idx){
        if(chk[idx])
            return;

        chk[idx] = true;
        System.out.print(idx + " ");

        for(int p : node.get(idx)){
            if(!chk[p])
                dfs(p);
        }
    }
}
