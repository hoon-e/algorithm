package RE.bfs;

import java.util.*;
import java.io.*;

// 맥주 한박스에는 맥주 20개, 50m당 한병씩
// 편의점에 들렸을때 빈 병 버리고 새 맥주병을 살 수 있다.
public class n9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] graph = new ArrayList[n+2];

            for(int i=0; i<n+2; i++)
                graph[i] = new ArrayList<>();

            int[][] coord = new int[n+2][2];

            for(int i=0; i<n+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                coord[i][0] = Integer.parseInt(st.nextToken());
                coord[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<n+2; i++) {
                for(int j=i+1; j<n+2; j++) {
                    int dist = (Math.abs(coord[i][0] - coord[j][0]) + Math.abs(coord[i][1] - coord[j][1]));

                    if(dist <= 1000) { // 1000이하면 넣기
                        graph[i].add(j);
                        graph[j].add(i);
                    }
                }
            }

            boolean[] vst = new boolean[n+2];
            Queue<Integer> que = new LinkedList<>();
            vst[0] = true;
            que.offer(0);

            while(!que.isEmpty()) {
                int cur = que.poll();

                for(int next : graph[cur]) {
                    if(!vst[next]) {
                        vst[next] = true;
                        que.offer(next);
                    }
                }
            }

            String ans = vst[n+1] ? "happy" : "sad";
            bw.write(ans+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
