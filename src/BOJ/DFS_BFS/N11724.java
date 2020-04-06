package BOJ.DFS_BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N11724 {
    static ArrayList<ArrayList<Integer>> node;
    static boolean[] chk;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        node = new ArrayList<>();

        for(int i=0; i<=N+1; i++)
            node.add(new ArrayList<>());

        for(int i=0; i<V; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            node.get(u).add(v);
            node.get(v).add(u);
        }

        chk = new boolean[N+1];

        for(int i=1; i<=N; i++){
            if(!chk[i]){
                dfs(i);
                count++;
            }
        }
        bw.write(count+"\n");
        bw.close();
        br.close();
    }

    static void dfs(int idx){
        chk[idx] = true; // idx를 true로
        for(int r : node.get(idx)){ // node idx에 있는 원소들을 dfs탐색
            if(!chk[r]){
                dfs(r);
            }
        }
    }
}
