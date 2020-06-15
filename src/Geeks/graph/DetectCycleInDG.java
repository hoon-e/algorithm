package Geeks.graph;

import java.io.*;
import java.util.*;

/*
방향 그래프에서 싸이클 찾기

싸이클을 찾을때에 DFS를 사용할 수 있다.

1. 정점과 에지를 이용하여 그래프 생성
2. 현재 정점의 인덱스와, 방문, 재귀 스택을 초기화하는 함수를 생성합니다.
3. 현재 노드를 방문했다고 저장하고, 재귀 스택에 인덱스를 저장한다.
4. 현재 노드에서 인접해있는 방문하지않은 모든 노드들을 방문한다.
5. 재귀 스택에서 인접 정점이 이미 체크되어있다면 true를 반환한다.
*/

// TODO: 도식화 해보기
public class DetectCycleInDG {
    private final int V;
    private final List<List<Integer>> adj;

    public DetectCycleInDG(int V){
        this.V = V;
        adj = new ArrayList<>();

        for(int i=0; i<V; i++)
            adj.add(new LinkedList<>());
    }

    private void addEdge(int src, int dst){
        adj.get(src).add(dst);
    }

    private boolean isCyclicUtil(int i, boolean[] vst, boolean[] rStack){
        // mark recursion stack
        if(rStack[i])
            return true;

        if(vst[i])
            return false;

        vst[i] = true;
        rStack[i] = true;

        List<Integer> children = adj.get(i);
        
        for(int c : children){
            if(isCyclicUtil(c, vst, rStack))
                return true;
        }

        rStack[i] = false;
        return false;
    }

    // 그래프가 Cycle을 가지고 잇다면 true를 리턴하고, 아니라면 false를 리턴한다.
    private boolean isCyclic(){
        boolean[] vst = new boolean[V];
        boolean[] rStack = new boolean[V];

        for(int i=0; i<V; i++){
            if(isCyclicUtil(i, vst, rStack))
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        DetectCycleInDG graph = new DetectCycleInDG(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(graph.isCyclic())
            System.out.println("Graph contains cycle.");
        else
            System.out.println("Graph doesn't contain cycle.");

        in.close();
        out.close();
    }
}
