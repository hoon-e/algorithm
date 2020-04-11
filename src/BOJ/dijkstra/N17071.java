package BOJ.dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Dist implements Comparable<Dist> {
    int v;
    int dist;
    int Kdist;

    Dist(int v, int dist, int Kdist){
        this.v = v;
        this.dist = dist;
        this.Kdist = Kdist;
    }

    public int compareTo(Dist d){
        return dist - d.dist;
    }
}

public class N17071 {
    static int N;
    static int K;
    static int[] dist;
    static int INF = 500_001;
    static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[INF];

        Arrays.fill(dist, MAX);

        bw.write(dijkstra(N)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra(int start){
        PriorityQueue<Dist> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Dist(start, 0, K));

        while(!pq.isEmpty()){
            Dist d = pq.poll();

            int curV = d.v;
            int curDist = d.dist;
            int curK = d.Kdist;

            if(curK > INF)
                break;

            if(curV == curK) {
                return curDist;
            }

            if(curV * 2 < INF){
                dist[curV*2] = curDist+1;
                pq.offer(new Dist(curV*2, curDist+1, curK+curDist+1));
            }

            if(curV + 1 < INF){
                dist[curV + 1] = curDist+1;
                pq.offer(new Dist(curV+1, curDist+1, curK+curDist+1));
            }

            if(curV - 1 >= 0){
                dist[curV - 1] = curDist+1;
                pq.offer(new Dist(curV-1, curDist+1, curK+curDist+1));
            }
        }
        return -1;
    }
}
