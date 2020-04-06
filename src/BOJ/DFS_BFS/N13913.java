package BOJ.DFS_BFS;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N13913 {
    static class Edge implements Comparable<Edge>{
        int v;
        int dist;

        Edge(int v, int dist){
            this.v = v;
            this.dist = dist;
        }

        public int compareTo(Edge e){
            return dist - e.dist;
        }
    }

    static int N;
    static int K;
    static int[] dist;
    static int[] path;
    static final int MAX = 100_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] ans;

        dist = new int[MAX];
        path = new int[MAX];

        Arrays.fill(dist, MAX);

        int cnt = dijkstra(N);

        // 경로니까 경로가 없을 경우에도 start를 출력해주어야한다.
        if(cnt == 0){
            bw.write(cnt+"\n");
            bw.write(N+"");
        }else{
            bw.write(cnt+"\n");
            ans = new int[cnt+10];

            int start = K;
            int j = cnt;
            ans[j] = start;

            while(start != N){
                j--;
                start = path[start];
                ans[j] = start;
            }

            for(int i=0; i<cnt+1; i++)
                bw.write(ans[i]+ " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[start] = 0;
        path[start] = start;
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int curV = e.v;
            int curDist = e.dist;

            if(curV == K){
                return curDist;
            }

            if(curV * 2 < MAX){
                if(dist[curV * 2] > curDist + 1){
                    dist[curV * 2] = curDist + 1;
                    path[curV * 2] = curV;
                    pq.offer(new Edge(curV * 2, dist[curV * 2]));
                }
            }

            if(curV + 1 < MAX){
                if(dist[curV + 1] > curDist + 1){
                    dist[curV + 1] = curDist + 1;
                    path[curV + 1] = curV;
                    pq.offer(new Edge(curV + 1, dist[curV + 1]));
                }
            }

            if(curV - 1 >= 0){
                if(dist[curV - 1] > curDist + 1){
                    dist[curV - 1] = curDist + 1;
                    path[curV - 1] = curV;
                    pq.offer(new Edge(curV - 1, dist[curV - 1]));
                }
            }
        }
        return 0;
    }
}
