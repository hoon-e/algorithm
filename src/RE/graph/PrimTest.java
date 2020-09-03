package RE.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[][] input = new int[V][E];
			int[] minEdge = new int[V];
			boolean[] visited = new boolean[V];
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<V; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
				minEdge[i] = Integer.MAX_VALUE;
			}
			
			int minVertex, min, result = 0;
			
			// 0번 정점을 시작점으로 한다고 가정
			minEdge[0] = 0; // 시작점 최소 간선비용은 0
			
			
			// 정점 N번만큼 반복한다.
			for(int c=0; c<V; c++) {
				// 최소 간선 비용의 정점을 찾기
				min = Integer.MAX_VALUE;
				minVertex = 0;
				
				for(int i=0; i<V; i++) {
					if(!visited[i] && min > minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}
				
				result += min; // 신장트리에 비용 누적
				visited[minVertex] = true;
				
				// 선택된 최소 비용 정점 기준으로 신장트리에 포함되지않은 다른 정점으로의 비용을 계산하여 최솟값을 갱신한다.
				for(int i=0; i<V; i++) {
					if(!visited[i]
							&& input[minVertex][i] != 0 
							&& minEdge[i] > input[minVertex][i]) {
						minEdge[i] = input[minVertex][i];
					}
				}
			}
			
			System.out.println("#" + tc + " " + result + "\n");
		}
	}
}
