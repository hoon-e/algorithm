package kakao;

import java.awt.desktop.SystemSleepEvent;
import java.io.*;
import java.util.*;

public class y19_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] relation = {{"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };

        int answer = solution(relation);
        System.out.println(answer);
    }

    /* 후보키 - Relation table 관련
     * 유일성 : 릴레이션에 있는 모든 튜플에 대해서 유일하게 식별되어야한다.
     * 최소성
     * 
     * 문제 아이디어 - 비트를 사용한다.(부분집합의 개념)
     */

    static boolean check(String[][] relation, int row, int col, int sub){
        for(int a = 0; a < row - 1; a++){
            for(int b = a + 1; b < row; b++){
                boolean isSame = true;

                for(int k = 0; k < col; k++){
                    if( (sub & (1 << k)) == 0 ) continue;
                    if(!relation[a][k].equals(relation[b][k])){
                        isSame = false;
                        break;
                    }
                }

                if(isSame) return false;
            }
        }
        return true;
    }

    static Comparator<Integer> comp = new Comparator<Integer>() {
        // 비트를 세는 함수
        public int countBits(int n) {
            int result = 0;

            // n이 0이 될때까지 반복
            while (n != 0) {
                if ((n & 1) != 0) result++;
                n = n >> 1; // 오른쪽을 하나씩 없애는데, 맨 오른쪽 비트가 0이 아니라면 추가
            }
            return result;
        }

        @Override
        public int compare(Integer a, Integer b) {
            int x = countBits(a), y = countBits(b);

            if (x > y)
                return 1;
            else if (x < y)
                return -1;
            else
                return 0;
        }
    };

    static public int solution(String[][] relation){
        int answer = 0;
        int rowsize = relation.length;
        int colsize = relation[0].length;

        // 유일성을 먼저 계산하고, 최소성을 판단한다.
        List<Integer> candidates = new LinkedList<>();

        // 부분집합 생성 ( 1 ~ 15 까지 모든 부분집합을 표현이 가능하다. )
        for(int i=1; i< (1 << colsize); i++){
            if( check(relation, rowsize, colsize, i) )
                candidates.add(i); // 유일성을 만족하는 튜플을 찾았다.
        }

        candidates.sort(comp);

        while(candidates.size() != 0){
            int num = candidates.remove(0);
            answer++;

            for(Iterator<Integer> it = candidates.iterator(); it.hasNext(); ){
                int c = it.next();

                // 최소성을 만족하지 못한다. 왜냐하면 유일성을 만족하는 키를 가지고 있다.
                if((num & c) == num){
                    it.remove();
                }
            }
        }
        return answer;
    }
}
