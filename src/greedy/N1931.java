package greedy;

import java.io.*;
import java.util.*;

public class N1931 {
    /*
    현재 t시간이라고 할때, 시작 시간이 t이상인 모든 회의 중에서
    가장 먼저 끝나는 회의를 택하는 것이 가장 좋은 선택
     */

    static class Meeting {
        int start;
        int end;

        public Meeting(int end, int start){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        LinkedList<Meeting> m = new LinkedList<>();

        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m.push(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Comparator<Meeting> timeComparator = (o1, o2) -> {
            if(o1.start == o2.start){
                return o1.end - o2.end;
            }else
                return o1.start - o2.start;
        };

        m.sort(timeComparator);

        int ans = 0;
        int t =0; // 현재 시간

        for(Meeting meet : m){
            if(t > meet.end) continue;
            ans++;
            t = meet.start;
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
