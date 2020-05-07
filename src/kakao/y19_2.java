package kakao;

import java.io.*;
import java.util.*;

public class y19_2 {
    static class Fail {
        int stage; // 스테이지
        double rate; // 실패율

        Fail(int stage, double rate){
            this.stage = stage;
            this.rate = rate;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] ans = solution(N, stages);

        for(int w : ans)
            System.out.print(w + " ");
    }

    /**
     * 실패율
     * 스테이지마다의 실패율을 구하는 문제
     * 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
     *
     * N : 1 ~ 500
     * stages : 1 ~ 200,000
     **/

    static Comparator<Fail> comp = new Comparator<Fail>() {
        @Override
        public int compare(Fail o1, Fail o2) {
            if(o1.rate < o2.rate)
                return 1;
            else if(o1.rate > o2.rate)
                return -1;
            else{
                if(o1.rate == o2.rate)
                    return o1.stage - o2.stage;
                else
                    return 0;
            }
        }
    };

    public static int[] solution(int N, int[] stages){
        int[] answer = new int[N];
        List<Fail> fails = new ArrayList<>();

        int total = stages.length;

        int[] users = new int[N+1];

        for(int s : stages)
            users[s-1]++;

        for(int i=0; i<N; i++){
            if(users[i] == 0)
                fails.add(new Fail(i+1, 0));
            else{
                fails.add(new Fail(i+1, (double)users[i]/total));
                total -= users[i];
            }
        }

        Collections.sort(fails, comp);

        for(int i=0; i<N; i++)
            answer[i] = fails.get(i).stage;

        return answer;
    }
}
