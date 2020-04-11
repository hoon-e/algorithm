package BOJ.DFS_BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N17071_2 {
    static int[] even_vst;
    static int[] odd_vst;
    static int N;
    static int K;
    static final int MAX = 500_001;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        N = scn.nextInt();
        K = scn.nextInt();

        even_vst = new int[MAX];
        odd_vst = new int[MAX];

        Arrays.fill(even_vst, -1);
        Arrays.fill(odd_vst, -1);

        System.out.println(BFS());
        scn.close();
    }

    static int BFS(){
        Queue<Integer> q = new LinkedList<>();
        int day = 0;

        int how = 0;
        odd_vst[N] = 0;
        even_vst[N] = 0;

        q.offer(N);

        while(!q.isEmpty()){
            int time = q.poll();

            day++;
            K += day;

            if(K > MAX)
                return -1;

            if(how % 2 == 0){
                if(time - 1 >= 0){
                    if(even_vst[time - 1] != -1 || time - 1 == K) {
                        System.out.println(time - 1 + " " + K);
                        return even_vst[time - 1];
                    }
                    even_vst[time - 1] = even_vst[time] + 1;
                    q.offer(time - 1);
                }
                if(time + 1 < MAX){
                    if(even_vst[time + 1] != -1 || time + 1 == K) {
                        System.out.println(time + 1 + " " + K);
                        return even_vst[time + 1];
                    }
                    even_vst[time + 1] = even_vst[time] + 1;
                    q.offer(time + 1);
                }
                if(time * 2 < MAX){
                    if(even_vst[time * 2] != -1 || time * 2 == K) {
                        System.out.println(time * 2 + " " + K);
                        return even_vst[time * 2];
                    }
                    even_vst[time * 2] = even_vst[time] + 1;
                    q.offer(time * 2);
                }
            }
            else{
                if(time - 1 >= 0){
                    if(odd_vst[time - 1] != -1 || time - 1 == K) {
                        System.out.println(time - 1 + " " + K);
                        return odd_vst[time - 1];
                    }
                    odd_vst[time - 1] = odd_vst[time] + 1;
                    q.offer(time - 1);
                }
                if(time + 1 < MAX){
                    if(odd_vst[time + 1] != -1 || time + 1 == K) {
                        System.out.println(time+1 + " " + K);
                        return odd_vst[time + 1];
                    }
                    odd_vst[time + 1] = odd_vst[time] + 1;
                    q.offer(time + 1);
                }
                if(time * 2 < MAX){
                    if(odd_vst[time * 2] != -1 || time * 2 == K) {
                        System.out.println(time*2 + " " + K);
                        return odd_vst[time * 2];
                    }
                    odd_vst[time * 2] = odd_vst[time] + 1;
                    q.offer(time * 2);
                }
            }
            how++;
        }
        return -1;
    }
}
