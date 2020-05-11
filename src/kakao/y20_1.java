package kakao;

import java.io.*;

public class y20_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public int solution(String s){
        int answer = s.length();

        // 문자열 절반 까지만 반복해주면 된다.
        for(int i=1; i <= s.length()/2; i++){
            int pos = 0;
            int len = s.length();

            for( ; pos + i <= s.length(); ){
                String unit = s.substring(pos, pos+i);
                pos += i;

                int cnt = 0;
                for( ; pos + i <= s.length(); ){
                    if(unit.equals(s.substring(pos, pos+i))){
                        cnt++;
                        pos += i;
                    }else
                        break;
                }

                if(cnt > 0){
                    len -= cnt * i;

                    if(cnt < 9)
                        len += 1;
                    else if(cnt < 99)
                        len += 2;
                    else if(cnt < 999)
                        len += 3;
                    else
                        len += 4;
                }
            }
            answer = Math.min(answer, len);
        }

        return answer;
    }
}
