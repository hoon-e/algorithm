package BOJ.heap;

import java.io.*;
import java.util.*;

/*
1. 진입 차수가 0 - 들어오는 간선의 수가 0
    - 진입 차수가 0인 정점이 여러개 존재할 경우엔 어느 정점을 선택해도 무방하다.
    - 초기에 간선의 수가 0인 모든 정점을 큐에 삽입
2. 선택된 정점과 여기에 부속된 모든 간선을 삭제한다.
    - 선택된 정점을 큐에서 삭제
    - 선택된 정점에 부속된 모든 간선에 대해 간선의 수를 삭제
3. 위의 과정을 반복, 모든 정점이 선택, 삭제되면 알고리즘 종료
 */

public class n2252 {
    static int N;
    static int M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 간선의 수
        int[] edges = new int[N+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        sb = new StringBuilder();

        for(int i=0; i<N+1; i++)
            graph.add(new ArrayList<>());

        // graph 연결 설정
        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);

            // 후행 정점에 대한 간선의 수를 증가시킨다.
            ++edges[v2];
        }

        topologicalSort(graph, edges);

        out.write(sb.toString());
        out.flush();
        out.close();
        in.close();
    }

    static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] edges){
        Queue<Integer> queue = new LinkedList<>();

        // 선행 정점을 가지지 않는 정점을 큐에 삽입한다.
        for(int i=1; i<N+1; i++){
            if(edges[i] == 0) {
                queue.offer(i);
            }
        }

        // 정점의 수 만큼 반복한다.
        for(int i=0; i<N; i++){
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for(int next : graph.get(cur)){
                --edges[next];

                if(edges[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }
}
