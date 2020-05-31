package Geeks.dp;

import java.io.*;
import java.util.*;

// All pairs Shortest Path problem

/*
1. 인풋 그래프와 같은 배열을 생성한다.
2. 선택한 정점을 지나는 가장 짧은 경로를 선택한다.

(i, j) 쌍은 각각 출발점과 도착점을 나타내고, 여기에는 두가지의 가능한 경우가 존재합니다.

1) k는 i 에서 j까지의 최단경로에서 중간 지점이 아니다. dist[i][j]의 값을 유지합니다.
2) k는 i에서 j까지 가는 최단 경로의 중간지점입니다. 우리는 dist[i][j]의 값을 dist[i][k] + dist[k][j]로 초기화합니다.(dist[i][j] 가 dist[i][k]+dist[k][j]보다 작을 경우)
 */
public class FloydWarshall {
    final static int INF = 99999, V = 4;

    void floydWarshall(int[][] graph){
        int[][] dist = new int[V][V];

        /* 솔루션 배열을 원 배열과 같게 만듭니다. */
        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                dist[i][j] = graph[i][j];
            }
        }

        for(int k=0; k<V; k++){
            for(int i=0; i<V; i++){
                for(int j=0; j<V; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution(dist);
    }

    void printSolution(int[][] dist){
        System.out.println("모든 좌표 들간의 최단 거리를 출력합니다.\n");

        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] graph = {{0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}};

        FloydWarshall fw = new FloydWarshall();
        fw.floydWarshall(graph);

        out.flush();
        in.close();
        out.close();
    }
}
