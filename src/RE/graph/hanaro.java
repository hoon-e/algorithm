package RE.graph;

import java.util.*;
import java.io.*;

public class hanaro {
    static int N, cnt;
    static long min;
    static int[] p;
    static PriorityQueue<Node> pq;

    /**
     * 크루스칼 알고리즘을 이용한 MST
     * @since 2020.09.04
     *
     */
    static class Node implements Comparable<Node>{
        int v1;
        int v2;
        long dist;

        public Node(int v1, int v2, long dist) {
            super();
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) { //오름차순
            return Long.compare(dist, o.dist);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            int[] x = new int[N];
            int[] y = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }

            pq = new PriorityQueue<Node>();
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    long dist = getDist(x[i],x[j], y[i],y[j]);
                    pq.add(new Node(i, j, dist));
//                    pq.add(new Node(j, i, dist));
                }
            } //간선에 대한 정보 저장

            double E = Double.parseDouble(br.readLine());
            //input end
            cnt = 0;
            min = 0;
            kruskal();

            System.out.println("#"+tc+" "+ Math.round(E*min));
        }//end test case
    }//end main

    private static void kruskal() {
        //make-set
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }

        while(cnt < N-1) {
            Node n = pq.poll();
            union(n);
        }
    }
    private static void union(Node n) {
        int x = n.v1;
        int y = n.v2;
        x = find(x);
        y = find(y);

        if(x!=y) {
            p[y] = x;
            min+=n.dist;
            cnt++;
        }
    }

    private static int find(int x) {
        if(p[x] == x) {return x;}
        return p[x] = find(p[x]);
    }

    private static long getDist(int x1, int x2, int y1, int y2) {
        return (long) (Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));

    }
}
