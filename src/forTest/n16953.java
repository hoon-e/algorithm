package forTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n16953 {
	static long A, B;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		A = scn.nextInt();
		B = scn.nextInt();
		
		HashMap<Long, Integer> dist = new HashMap<>();

		Queue<Long> q = new LinkedList<>();
		dist.put(A, 0);
		q.offer(A);
		
		/** DP나 반복문으로 풀 수 있다. **/
		while(!q.isEmpty()) {
			long cur = q.poll();
			
			if(cur == B) {
				System.out.println(dist.get(B)+1);
				return;
			}
			
			long pls = cur*10 + 1;
			long two = cur*2;
			
			if(pls <= B) {
				if(dist.get(pls) == null) {
					dist.put(pls, dist.get(cur)+1);
					q.offer(pls);
				} else {
					if(dist.get(pls) > dist.get(cur)+1) {
						dist.put(pls, dist.get(cur)+1);
						q.offer(pls);
					}
				}
			}
			
			if(two <= B) {
				if(dist.get(two) == null) {
					dist.put(two, dist.get(cur)+1);
					q.offer(two);
				} else {
					if(dist.get(two) > dist.get(cur)+1) {
						dist.put(two, dist.get(cur)+1);
						q.offer(two);
					}
				}
			}
		}
		
		if(dist.get(B) == null)
			System.out.println("-1");
	}
}
