package BOJ.tree;

import java.io.*;
import java.util.*;

class edges {
    int child;
    int weight;

    edges(int child, int weight){
        this.child = child;
        this.weight = weight;
    }
}

public class N1967 {
    static ArrayList<edges>[] nodes;
    static edges maxCur;
    static int cur;
    static int[] dist;
    static int MAX = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        nodes = new ArrayList[n+1];
        dist = new int[n+1];

        for(int i=1; i<=n; i++)
            nodes[i] = new ArrayList<>();

        // 정보 추가
        for(int i=0; i<n-1; i++){
            String[] nums = br.readLine().split(" ");
            int p = Integer.parseInt(nums[0]);
            int c = Integer.parseInt(nums[1]);
            int w = Integer.parseInt(nums[2]);
            nodes[p].add(new edges(c, w));
            nodes[c].add(new edges(p, w));
        }

        // 1번부터 시작하여 최대 깊이를 찾는다.
        DFS(1, 0);
        // 최대 정점부터 다시 DFS를 실행하여 최대 길이를 찾는다.
        dist = new int[n+1];
        MAX = -1;
        DFS(cur, 0);

        System.out.println(MAX);
    }

    public static void DFS(int vtx, int w){
        dist[vtx] = w;

        if(dist[vtx] > MAX){
            MAX = dist[vtx];
            cur = vtx;
        }

        for(edges e : nodes[vtx]){
            if(dist[e.child] == 0)
                DFS(e.child, w + e.weight);
        }
    }
}
