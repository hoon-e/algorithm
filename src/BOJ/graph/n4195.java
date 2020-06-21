package BOJ.graph;

import java.io.*;
import java.util.*;

public class n4195 {
    static int tc;
    static int F;
    static int[] parent;
    static int[] link;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        tc = Integer.parseInt(in.readLine());
        sb = new StringBuilder();

        for(int i=0; i < tc; i++) {
            F = Integer.parseInt(in.readLine());
            int idx = 1;
            Map<String, Integer> friends = new HashMap<>();

            parent = new int[200001];
            link = new int[200001];

            for(int j=1; j<200001; j++){
                parent[j] = j;
                link[j] = 1;
            }

            for(int j=0; j < F; j++){
                StringTokenizer st = new StringTokenizer(in.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!friends.containsKey(a)){
                    friends.put(a, ++idx);
                }

                if(!friends.containsKey(b)){
                    friends.put(b, ++idx);
                }

                int px = friends.get(a);
                int py = friends.get(b);

                union(px, py);
            }
        }

        out.write(sb.toString());
        out.flush();
        in.close();
        out.close();
    }

    static void union(int u, int v){
        u = find(u);
        v = find(v);

        if(u == v){
            sb.append(link[u]).append("\n");
            return;
        }

        parent[u] = v;
        link[v] += link[u];
        sb.append(link[v]).append("\n");
    }

    static int find(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
}