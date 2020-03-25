package greedy;

import java.io.*;
import java.util.*;

public class N2457_try {
    static class Flower implements Comparable<Flower> {
        private int start;
        private int end;

        public int compareTo(Flower f){
            if(this.start == f.start){
                return this.end - f.end;
            }else
                return this.start - f.start;
        }

        Flower(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Flower[] flower = new Flower[num];

        // 날짜에 달에 100을 곱해서 네자리 숫자로 만든후 비교를 하는 아이디어
        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int smonth = Integer.parseInt(st.nextToken())*100;
            int sday = Integer.parseInt(st.nextToken());
            int fmonth = Integer.parseInt(st.nextToken())*100;
            int fday = Integer.parseInt(st.nextToken());
            flower[i] = new Flower(smonth+sday, fmonth+fday);
        }

        Arrays.sort(flower, 0, num);

        int date = 301;
        boolean flag;
        int f=0;
        int i = -1;
        int temp = 0;

        while( date <= 1130 && i < num ){
            flag = false;
            i++;

            for(int j=i; j<num; j++){
                if(flower[j].start > date ) break;
                if(temp < flower[j].end ){
                    temp = flower[j].end;
                    flag = true;
                    i = j;
                }
            }
            if(flag){
                f++;
                date = temp;
            }else{
                bw.write("0");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }
        bw.write(f+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
