package BOJ.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class N1946 {
    static class Std implements Comparable<Std>{
        int p;
        int m;

        public Std(int p, int m) {
            this.p = p;
            this.m = m;
        }

        // 쓸모없는 정렬조건이 있다면 더 비효율 적일 수 있다.
        public int compareTo(Std s){
            return p - s.p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            ArrayList<Std> std = new ArrayList<>();

            int num = Integer.parseInt(br.readLine());

            for(int i=0; i<num; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                std.add(new Std(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Collections.sort(std);

            int count = 1;
            int max = std.get(0).m;

            for(int i=1; i<std.size(); i++){
                if(max > std.get(i).m) {
                    max = std.get(i).m;
                    count++;
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
