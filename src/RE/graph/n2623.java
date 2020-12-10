package RE.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

        public class n2623 {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder sb = new StringBuilder();

                StringTokenizer st = new StringTokenizer(br.readLine());

                int N = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                int[] degree = new int[N+1];

                ArrayList<ArrayList<Integer>> order = new ArrayList<>();

                for(int i=0; i<N+1; i++)
                    order.add(new ArrayList<>());

                for(int i=0; i<M; i++) {
                    st = new StringTokenizer(br.readLine());

                    int number = Integer.parseInt(st.nextToken());
                    int first = Integer.parseInt(st.nextToken());

                    for(int j=0; j<number-1; j++) {
                        int next = Integer.parseInt(st.nextToken());

                        order.get(first).add(next);
                        degree[next]++;
                        first = next;
                    }
                }

                Queue<Integer> q = new LinkedList<>();
                int cnt = 0;

                for(int i=1; i<=N; i++) {
                    if(degree[i] == 0)
                        q.offer(i);
                }

                for(int i=1; i<=N; i++) {
                    if(q.isEmpty()) break;
                    int cur = q.poll();
                    cnt++;

                    sb.append(cur).append("\n");

                    for(int next : order.get(cur)) {
                        degree[next]--;

                        if(degree[next] == 0) {
                            q.offer(next);
                        }
                    }
                }

                if(cnt == N) {
                    System.out.println(sb.toString());
                } else {
                    System.out.println(0);
                }
            }
        }