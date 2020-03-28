package backtracking;

import java.io.*;
import java.util.StringTokenizer;

// n개의 트럭이 건넌다. 트럭의 순서는 못바꾸고 트럭의 무게는 서로 같지않을 수 있다.
// w대의 트럭만 올라갈 수 있다. 최대하중인 L보다 작거나 같아야한다.

public class N13335 {
    static int t;
    static int W;
    static int L;
    static int[] trucks;
    static int[] chk;
    static int day;
    static int weight;
    static int pivot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        trucks = new int[t];
        chk = new int[t];

        st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            trucks[i++] = Integer.parseInt(st.nextToken());
        }

        bw.write(day+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static void through(){

        for(int i=0; i<t; i++){
            if(chk[i] < 2){

            }
        }
    }
}
