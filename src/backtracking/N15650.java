package backtracking;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15650 {
    static int N;
    static int M;
    static StringBuffer sb;
    static ArrayList<int[]> ans_list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuffer();
        boolean[] used = new boolean[N];
        int[] ans = new int[M];
        ans_list = new ArrayList<>();
        find(ans, used, 0);
        // 어떤 수가 수열에 이미 쓰였는가
        // 어떤 수가 아직 쓰이지 않았는가
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void find(int[] ans, boolean[] used, int num){
        if(num == M){
            int[] a = new int[M];
            System.arraycopy(ans, 0, a, 0, M);
            Arrays.sort(a); // 정렬

            if(ans_list.isEmpty())
                ans_list.add(a);
            else{
                for(int[] d : ans_list){
                    boolean flag = false;
                    int count=0;
                    for(int i=0; i<M; i++){
                        if(d[i] == a[i]){
                            flag=true;
                            count++;
                        }else
                            flag=false;
                    }
                    if(flag && count==M)
                        return;
                }
            }
            ans_list.add(a);

            for(int i=0; i<M; i++)
                sb.append((a[i]+1)).append(" ");
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!used[i]){
                ans[num] = i;
                used[i] = true;
                find(ans, used, num+1);
                used[i] = false;
            }
        }
    }
}
