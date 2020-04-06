package BOJ.bojsolve2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int index;
	int cls;
	
	Node(int index, int cls){
		this.index = index;
		this.cls = cls;
	}
}

public class N1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int testcase=Integer.parseInt(br.readLine());
		
		for(int x=0; x<testcase; x++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Node> q = new LinkedList<>();

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Node[] c = new Node[N];
			
			st = new StringTokenizer(br.readLine());
			int i = 0;
			
			while(st.hasMoreTokens()) {
				c[i] = new Node(i, Integer.parseInt(st.nextToken()));
				q.offer(c[i]);
				i++;
			}
			
			int result = M;
			int count = 0;
			int ans_index = Integer.MIN_VALUE;
			
			while(true) {
				int ans = q.peek().cls;
				ans_index = q.peek().index;
				boolean flag = false;
				
				for(Node n : q) {
					if( n.cls > ans ) {
						Node s = new Node(ans_index, ans);
						q.poll();
						q.offer(s);
						ans_index = q.peek().index;
						flag=true;
						break;
					}
				}
				
				if(!flag) {
					q.poll();
					count++;
					
					if(ans_index == result)
						break;
				}
			}
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
