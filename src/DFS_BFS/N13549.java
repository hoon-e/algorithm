package DFS_BFS;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 알고리즘을 이용할때에는 간선의 가중치가 갱신이 될 수 있으므로 조심한다.
class Edge implements Comparable<Edge>{
    int vertex;
    int weight;

    Edge(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }

    public int compareTo(Edge e){
        return weight - e.weight;
    }
}

public class N13549 {
    static int N;
    static int K;
    static int[] dist;
    static final int MAX = 100_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[MAX];

        Arrays.fill(dist, MAX);

        bw.write(dijkstra(N)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            int curVtx = cur.vertex;
            int curDist = cur.weight;

            if(curVtx == K) {
                return curDist;
            }

            if(curVtx * 2 < MAX){
                if(dist[curVtx*2] > curDist){
                    dist[curVtx*2] = curDist;
                    pq.offer(new Edge(curVtx * 2, curDist));
                }
            }
            if(curVtx + 1 < MAX){
                if(dist[curVtx+1] > curDist+1){
                    dist[curVtx+1] = curDist+1;
                    pq.offer(new Edge(curVtx + 1, curDist + 1));
                }
            }
            if(curVtx - 1 >= 0){
                if(dist[curVtx-1] > curDist+1){
                    dist[curVtx-1] = curDist+1;
                    pq.offer(new Edge(curVtx - 1, curDist + 1));
                }
            }
        }
        return 0;
    }
}
