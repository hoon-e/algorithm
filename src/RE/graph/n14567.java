package RE.graph;

import java.util.*;
import java.io.*;

public class n14567 {
    static class node {
        int idx;
        node next;

        node(int idx, node next) {
            this.idx = idx;
            this.next = next;
        }
    }

    static int N, M;
    static int[] indegree, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];
        ans = new int[N+1];
        node[] nodes = new node[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int pre = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            nodes[next] = new node(pre, nodes[next]);
            indegree[pre]++;
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) {
                q.offer(new int[]{i, 0});
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            node head = nodes[cur[0]];

            while(head != null) {
                indegree[head.idx]--;
                System.out.println(head.idx);
                if(indegree[head.idx] == 0) {
                    q.offer(new int[]{head.idx, ans[cur[0]] });
                }
                head = head.next;
            }
        }

        for(int i=N; i>=1; i--)
            bw.write(ans[i] + " ");
        bw.flush();
    }
}
