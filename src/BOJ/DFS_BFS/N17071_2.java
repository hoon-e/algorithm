package BOJ.DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N17071_2 {
    static int[][] vst;
    static int N;
    static int K;
    static final int MAX = 500_001;
    static final int INF = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        N = scn.nextInt();
        K = scn.nextInt();

        vst = new int[2][MAX];

        Arrays.fill(vst[0], INF);
        Arrays.fill(vst[1], INF);
        vst[0][N] = 0;

        if(N == K)
            System.out.println(0);
        else
            System.out.println(BFS());
        scn.close();
    }

    static int BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        int time=0;
        int eo;

        while(!q.isEmpty()){
            int size = q.size();
            time++;
            eo = time % 2;

            for(int i=0; i<size; i++){
                int cur = q.poll();

                if( cur - 1 >= 0 ){
                    if(vst[eo][cur-1] == INF){
                        vst[eo][cur-1] = time;
                        q.offer(cur-1);
                    }
                }
                if( cur + 1 < MAX ){
                    if(vst[eo][cur+1] == INF){
                        vst[eo][cur+1] = time;
                        q.offer(cur+1);
                    }
                }
                if( cur * 2 < MAX){
                    if(vst[eo][cur*2] == INF){
                        vst[eo][cur*2] = time;
                        q.offer(cur*2);
                    }
                }
            }
            int nk = K + (time*(time+1))/2;
            if(nk > MAX-1) break;
            if(vst[eo][nk] != INF) return time;
        }
        return -1;
    }
}
