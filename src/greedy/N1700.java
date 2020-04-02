package greedy;

import java.io.*;
import java.util.*;

public class N1700 {
    static int N;
    static int K;
    static int[] consent = new int[101];
    static LinkedList<Integer> o = new LinkedList<>();
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            int idx = Integer.parseInt(st.nextToken());
            o.add(idx);
        }

        for(int i=0; i<K; i++){
            int cur = o.get(i);
            if(isPut(cur)){
                // nothing
            }else{
                if(!isFull(cur)) {
                    int mid = 0;
                    int max = 0;
                    boolean reuse = true;

                    // 꽂혀있는 콘센트 탐색
                    for (int j = 1; j <= N; j++) {
                        int temp = 1;
                        boolean flag = true;

                        // k는 현재부터 다음까지 쓰여진 번호가 있는지 탐색한다.
                        for(int k=i; k<o.size(); k++, temp++){
                            if(consent[j] == o.get(k)){
                                // 만약 꽂혀있는 콘센트가 뒤에 나온다면,
                                if(temp > max){ // 몇번 뒤에 나오는지 계산하고
                                    max = temp;
                                    mid = j; // 현재의 콘센트를 체크한다.
                                }
                                flag = false;
                                break;
                            }
                        }

                        // 만약 뒤에 사용하는 콘센트가 없다면
                        if(flag){
                            consent[j] = cur;
                            // 현재 자리에 지금 값을 넣는다.
                            count++;
                            reuse = false;
                            break;
                        }
                    }

                    // 만약 뒤에 사용하는 콘센트가 있다면
                    if(reuse){
                        consent[mid] = cur;
                        count++;
                    }
                }
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isPut(int idx){
        for(int i=1; i<=N; i++){
            if(consent[i] == idx){
                return true;
            }
        }
        return false;
    }

    static boolean isFull(int idx){
        boolean flag = false;
        for(int i=1; i<=N; i++){
            if(consent[i] == 0) {
                consent[i] = idx;
                flag = true;
                break;
            }
        }
        return flag;
    }
}
