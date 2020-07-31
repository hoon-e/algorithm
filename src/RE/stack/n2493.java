package RE.stack;

import java.util.*;
import java.io.*;

public class n2493 {
    static class tower { // 탑 정보
        int idx; // 인덱스
        long height; // 높이

        tower(int idx, long height){
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        tower[] towers = new tower[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) // tower 정보 입력받는다.
            towers[i] = new tower(i+1, Long.parseLong(st.nextToken()));

        Stack<tower> heights = new Stack<>(); // 스택 이용

        for(tower t : towers) {
            if(heights.isEmpty()){ // 스택이 비어있다면, 닿을 수 있는 전파가 없으므로
                heights.push(t); // 현재 객체를 push하고
                bw.write(0 + " "); // 0을 출력한다.
            }else {
                if(heights.peek().height < t.height) {
                    // 만약 스택의 맨 위에 있는 높이가 현재 높이보다 작다면
                    // 현재 높이보다 큰 높이가 나올 때까지 스택의 값을 모두 뺀다.
                    while(!heights.isEmpty() && heights.peek().height < t.height) {
                        heights.pop();
                    }
                    // 만약 스택의 size가 0이라면, 전파가 닿을 수 있는 탑은 없다.
                    // 아니라면, 스택의 가장 위에 있는 idx를 꺼내준다.
                    int idx = (heights.size() == 0) ? 0 : heights.peek().idx;
                    heights.push(t);
                    bw.write(idx+ " ");
                }else {
                    // 만약 현재 높이가 스택의 맨 상위 값보다 작거나 같다면, 그냥 push한다.
                    bw.write(heights.peek().idx + " ");
                    heights.push(t);
                }
            }
        }

        bw.flush(); // 출력한다.
        bw.close();
        br.close();
    }
}