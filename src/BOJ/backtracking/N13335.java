package BOJ.backtracking;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// n개의 트럭이 건넌다. 트럭의 순서는 못바꾸고 트럭의 무게는 서로 같지않을 수 있다.
// w대의 트럭만 올라갈 수 있다. 최대하중인 L보다 작거나 같아야한다.

public class N13335 {
    static int t;
    static int W;
    static int L;
    static int[] trucks;
    static int day;
    static int weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        trucks = new int[t];

        st = new StringTokenizer(br.readLine());
        int i=0;
        while(st.hasMoreTokens()){
            trucks[i++] = Integer.parseInt(st.nextToken());
        }

        // 생각해놓고 못푼다...
        Queue<Integer> rod = new LinkedList<>();

        for(int j=0; j<t; j++){
            while(true){
                if(rod.size() == W){
                    weight -= rod.poll();
                }
                if(weight + trucks[j] <= L)
                    break;
                rod.offer(0);
                day++;
            }
            rod.offer(trucks[j]);
            weight += trucks[j];
            day++;
        }
        day += W;
        bw.write(day+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
