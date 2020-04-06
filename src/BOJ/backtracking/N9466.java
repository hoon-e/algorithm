package BOJ.backtracking;

import java.io.*;
import java.util.StringTokenizer;

// 사이클 찾기
public class N9466 {
    static int[] project;
    static boolean[] chk;
    static boolean[] fin;
    static int num;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        while(testcase-- > 0){
            num = Integer.parseInt(br.readLine());
            cnt=0;
            project = new int[num+1];
            chk = new boolean[num+1];
            fin = new boolean[num+1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int i=1;
            while(st.hasMoreTokens()){
                project[i++] = Integer.parseInt(st.nextToken());
            }

            for(int k=1; k<=num; k++){
                if(!chk[k]) {
                    dfs(k);
                }
            }
            bw.write((num-cnt)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx){
        chk[idx] = true;
        int next = project[idx];

        if(!chk[next])
            dfs(next);
        else{
            if(!fin[next]){
                int i= next;
                while(idx != i){
                    cnt++;
                    i = project[i];
                }
                cnt++;
            }
        }
        fin[idx] = true;
    }
}
