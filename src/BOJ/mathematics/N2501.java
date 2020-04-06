package BOJ.mathematics;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N2501 {
    static int N;
    static int K;
    static ArrayList<Integer> v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        divide(N);

        if(v.size() < K){
            bw.write(0+"\n");
        }else
            bw.write(v.get(K-1)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void divide(int n){
        v = new ArrayList<>();
        for(int i=1; i*i <= n; i++){
            if(n % i == 0)
                v.add(i);
        }
        for(int i = v.size()-1; i>=0; i--){
            if(v.get(i)*v.get(i) == n) continue;
            v.add((n/v.get(i)));
        }
    }
}
