package BOJ.DFS_BFS;

import java.io.*;
import java.util.*;

public class N1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] chk = new int[100010];
        Arrays.fill(chk, -1);

        int nx = n;
        int[] ns = new int[3];
        Queue<Integer> q = new LinkedList<>();
        q.add(nx);
        chk[nx] = 0;

        while(!q.isEmpty()){
            if(nx == k){
                break;
            }
            nx = q.poll();
            ns[0] = nx-1;
            ns[1] = nx+1;
            ns[2] = nx*2;

            for(int i=0; i<3; i++){
                if(ns[i] >= 0 && ns[i] <= 100000){
                    if(chk[ns[i]] == -1){
                        q.add(ns[i]);
                        chk[ns[i]] = chk[nx]+1;
                    }
                }
            }
        }

        bw.write(chk[k]+"\n");
        bw.flush();
        bw.close();
        br.close();

        /*
        for(int t=0; t<3; t++){
            Stack<Integer> s = new Stack<>();
            chk = new boolean[110000];
            chk[n] = true;

            int nx = n;
            if(t == 2)
                nx *= dir[t];
            else{
                nx += dir[t];
            }

            s.add(nx);
            chk[nx] = true;
            int sec = 1;

            boolean flag = false;
            while(!s.isEmpty()){
                if(flag)
                    break;
                int now = s.pop();
                sec++;
                for(int j=0; j<3; j++){
                    if(j==2)
                        now *= dir[j];
                    else
                        now += dir[j];

                    if(now < 0 || now > k+2 || chk[now]) continue;
                    chk[now] = true;
                    s.push(now);

                    if(now == k){
                        minsec = Math.min(sec, minsec);
                        flag = true;
                        break;
                    }
                }
            }
        }
        */
    }
}
