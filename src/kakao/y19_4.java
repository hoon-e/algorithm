package kakao;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class y19_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    /**
     * 무지의 먹방 라이브
     * 회전판에 N개의 음식
     * 1번부터 먹기 시작하여, K초 후에 네트워크 장애로 방송 잠시 중단
     * 시간 순으로 정렬하고, 남은 시간이 있다면 다시 정렬 후에 그 시간 끼리 나머지 연산을 하여 비교한다.
     */

    static class Food {
        int time;
        int idx;

        Food(int time, int idx){
            this.time = time;
            this.idx = idx;
        }
    }

    static Comparator<Food> compareTime = new Comparator<Food>(){
        @Override
        public int compare(Food a, Food b){
            return a.time - b.time;
        }
    };

    static Comparator<Food> compareIdx = new Comparator<Food>(){
        @Override
        public int compare(Food a, Food b){
            return a.idx - b.idx;
        }
    };

    static public int solution(int[] food_times, long k){
        List<Food> foods = new LinkedList<>();

        int n = food_times.length;

        // 시간 순으로 음식들을 정렬한다.
        for(int i=0; i<n; i++)
            foods.add(new Food(food_times[i], i+1));

        foods.sort(compareTime);

        int preTime = 0;
        int i = 0;

        // 남은 음식 수를 계산하는 부분
        for(Food f : foods){
            long diff = f.time - preTime;

            if( diff != 0 ){
                long spend = diff * n;

                if(spend <= k) { // k보다 작다면 k를 빼준다.
                    k -= spend;
                    preTime = f.time;
                }else{
                    k %= n;
                    // subList 새로 안 개념 현재 인덱스부터
                    foods.subList(i, food_times.length).sort(compareIdx);
                    return foods.get(i + (int)k).idx;
                }
            }
            i++;
            n--;
        }

        return -1;
    }
}
