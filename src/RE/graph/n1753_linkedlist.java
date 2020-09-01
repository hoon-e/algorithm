package RE.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n1753_linkedlist {
	
	// 연결리스트를 위한 노드 클래스
	static class Node {
		int dst;
		int weight;
		Node next;
		
		Node(int dst, int weight, Node next){
			this.dst = dst;
			this.weight = weight;
			this.next = next;
		}
	}
	
	// 간선 정보를 위한 정점 클래스
	static class Vtx implements Comparable<Vtx>{
		int dst;
		int weight;
		
		Vtx(int dst, int weight) {
			this.dst = dst;
			this.weight = weight;
		}
		
		public int compareTo(Vtx v) {
			return weight - v.weight;
		}
	}
	
	static int V, E, start;
	static Node[] nodes;
	static final int INFINITY = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		start = Integer.parseInt(br.readLine());	
		nodes = new Node[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 입력을 받으며, 해당 u 시작점에 v 종점까지의 객체를 연결해준다.
			nodes[u] = new Node(v, w, nodes[u]);
		}
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, INFINITY);
				
		PriorityQueue<Vtx> pq = new PriorityQueue<>();
		
		dist[start] = 0;
		pq.offer(new Vtx(start, 0));

		Node head = null;
		
		while(!pq.isEmpty()){
		    Vtx cur = pq.poll();

		    int curVtx = cur.dst;
		    int curWeight = cur.weight;

		    if(curWeight != dist[curVtx]) continue;
		    head = nodes[curVtx];
		    while(head != null) {
		    	int nextVtx = head.dst;
		    	int nextWeight = head.weight;
		    	
		    	if(nextWeight + curWeight < dist[nextVtx]) {
		    		dist[nextVtx] = nextWeight + curWeight;
		    		pq.offer(new Vtx(nextVtx, dist[nextVtx]));
		    	}
		    	
		    	head = head.next;
		    }
		}
	
		for(int i=1; i<=V; i++) {
			if(dist[i] == INFINITY) bw.write("INF\n");
			else bw.write(dist[i]+"\n");
		}
		
		bw.flush();
	}
}
