package RE.graph;

import java.util.*;
import java.io.*;

public class n9372 {
    static int N, M;
    static int[] parent, rank, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());


            count = new int[1001];
            parent = new int[N+1];
            rank = new int[N+1];

            for(int i=1; i<=N; i++) parent[i] = i;

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                union(u, v);
            }

            for(int i=1; i<=N; i++)
                parent[i] = find(parent[i]);

            int answer = 0;
            for(int i=1; i<=N; i++) ++count[parent[i]];

            for(int i=1; i<=1000; i++){
                if(count[i] != 0) {
                    ++answer;
                }
            }

            bw.write((N-answer) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int val) {
        return (val == parent[val]) ? val : (parent[val] = find(parent[val]));
    }

    private static void union(int u, int v){
        u = find(u);
        v = find(v);

        if(u == v) return;
        if(rank[u] < rank[v]) parent[u] = v;
        else parent[v] = u;
        if(rank[u] == rank[v]) ++rank[v];
    }
}
