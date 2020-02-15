package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n6549 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		while(true) {
			String[] line = br.readLine().split(" ");
			Stack<Integer> tower = new Stack<>();
			
			int num = Integer.parseInt(line[0]);
			long max = 0;
			
			if(num == 0)
				break;
			
			long[] height = new long[num];
			
			for(int i=0; i<num; i++) {
				height[i] = Long.parseLong(line[i+1]);
			}
			
			/*
			 * O(n)의 방법
			 * ! 직사각형의 번호를 스택의 높이를 기준으로 오름차순으로 넣어준다.
			 */
			for(int i=0; i<num; i++) {
				// tower가 비어있지 않고 타워의 가장위에 있는 인덱스의 높이가 지금 높이보다 클 동안
				while(!tower.isEmpty() && height[tower.peek()] > height[i]) {
					long h = height[tower.pop()];
					int width = i;
					
					if(!tower.isEmpty()) {
						width = i-tower.peek()-1;
					}
					if(max < width*h) {
						max = width*h;
					}
				}
				// tower가 비어있다면 인덱스를 추가한다.
				tower.push(i);
			}
			
			while(!tower.isEmpty()) {
				long h = height[tower.pop()];
				int width = num;
				
				if(!tower.isEmpty()) {
					width = num-tower.peek()-1;
				}
				if(max < width*h) {
					max = width*h;
				}
			}
			
			/** O(n*2) - 시간초과
			for(int i=0; i<num; i++) {
				int h = height[i];
				count = 0;
				max_count = 0;
				
				for(int j=0; j<num; j++) {
					if( height[j] >= h) {
						count++;
					}
					else {
						if( count >= max_count ) {
							max_count = count;
						}
						count = 0;
					}
				}
				
				if( count >= max_count ) {
					max_count = count;
				}
				area = h*max_count;
				
				if( area > max ) {
					max = area;
				}
			}
			**/
			
			bw.write(max+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
