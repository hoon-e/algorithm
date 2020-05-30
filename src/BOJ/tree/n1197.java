package BOJ.tree;

import java.io.*;
import java.util.*;

public class n1197 {
    static class edge {
        int start;
        int end;
        long weight;

        public edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int find(int x){
        if(weights[x] < 0) return x;
        return weights[x] = find(weights[x]);
    }

    static boolean findUnion(int s, int e){
        s = find(s);
        e = find(e);

        if(s == e) return false;
        if(weights[s] == weights[e])
            --weights[s];
        if(weights[s] < weights[e])
            weights[e] = s;
        else
            weights[s] = e;
        return true;
    }

    static int V;
    static int E;
    static int[] weights;
    static edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new edge[E];
        weights = new int[100001];

        Arrays.fill(weights, -1);

        for(int i=0; i<E; i++){
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());

            edges[i] = new edge(start, end, weight);
        }

        Arrays.sort(edges, (e1, e2) -> {
            if(e1.weight > e2.weight)
                return 1;
            else if(e1.weight < e2.weight)
                return -1;
            else
                return 0;
        });

        long ans = 0;
        int cnt = 0;
        for(int i=0; i<E; i++){
            long cost = edges[i].weight;
            int vtx1 = edges[i].start;
            int vtx2 = edges[i].end;
            if(!findUnion(vtx1, vtx2)) continue;
            ans += cost;
            ++cnt;
            if(cnt == V-1) break;
        }

        out.write(ans+"\n");
        out.flush();
        in.close();
        out.close();
    }
}
