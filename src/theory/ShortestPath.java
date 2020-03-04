package theory;

/**
 * 
 * @author kjhch
 *
 * 다익스트라 알고리즘
 * 하나의 정점에서, 다른 모든 정점들의 최단 경로를 구하는 알고리즘이다.
 * 첫 정점을 기준으로 연결되어있는 정점들을 추가해가며, 최단 거리를 갱신한다.
 */
public class ShortestPath {
	
	public int minDistance(int[] dist, Boolean[] b) {
		int min = Integer.MAX_VALUE, index=-1;
		for(int x=0; x<5; x++) {
			if(b[x] == false && dist[x] <= min) {
				min = dist[x];
				index=x;
			}
		}
		return index;
	}
	
	public void printGraph(int[] dist, int x) {
		System.out.println("특정 소스로부터 목적지까지의 최소거리");
		for(int i=0; i<x; i++) {
			System.out.println((char)(65) + "-->" + (char)(i+65) + " = " + dist[i]);
		}
	}
	
	public void dijkstra(int graph[][], int src) {
		int[] dist = new int[5];
		Boolean[] b = new Boolean[5];
		
		for(int i=0; i<5; i++) {
			dist[i] = Integer.MAX_VALUE;
			b[i]    = false;
		}
		
		dist[src] = 0;
		for(int count=0; count<5; count++) {
			int u = minDistance(dist,b);
			b[u] = true;
			for(int x=0; x<5; x++) {
				if(!b[x] && graph[u][x]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][x] < dist[x]) {
					dist[x] = dist[u] + graph[u][x];
				}
			}
		}
		printGraph(dist, 5);
	}
	public static void main(String[] args) {
		int graph[][] = new int[][] {
			
			/*
			 * 		   A
			 *	  (4) / \(7)
			 *       /   E   
			 *      B -----C(1)   
			 *    (2) \  /(6)
			 *    	   D 
			 */
			{0,4,0,0,7},
			{4,0,1,2,0},
			{0,1,0,6,0},
			{0,2,6,0,0},
			{7,0,0,0,0}};
			
		ShortestPath sp = new ShortestPath();
		sp.dijkstra(graph, 0);
	}
}
