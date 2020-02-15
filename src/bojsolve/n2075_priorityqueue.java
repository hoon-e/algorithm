package bojsolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class n2075_priorityqueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		/**
		 Priority Queue는 Queue의 모든 속성을 가지고 있으며,
		 Min Heap으로 데이터를 가지고 있으며 오름차순으로 poll을 해주는 자료구조이다. 
		 **/
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			pq.offer(temp);
		}
		
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(pq.peek() < temp) {
					pq.poll(); // 큐에서 우선순위가 가장 높은 요소를 빼낸다. 반환 후에 큐에서 삭제한다.
					pq.offer(temp);	
				}
			}
		}
		
		System.out.println(pq.poll());
	}
}
