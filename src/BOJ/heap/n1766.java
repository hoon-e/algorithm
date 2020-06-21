package BOJ.heap;

import javax.management.QueryEval;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class n1766 {
    static int N;
    static int M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] problem = new int[N+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        sb = new StringBuilder();

        for(int i=0; i<N+1; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            ++problem[b];
        }

        topologicalSort(graph, problem);

        out.write(sb.toString());
        out.flush();
        in.close();
        out.close();
    }

    static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] problem){
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=1; i<=N; i++){
            if(problem[i] == 0) {
                queue.offer(i);
            }
        }

        for(int i=0; i<N; i++){
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for(int next : graph.get(cur)){
                --problem[next];

                if(problem[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}
