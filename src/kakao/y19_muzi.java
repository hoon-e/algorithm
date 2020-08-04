package kakao;

import java.util.*;
import java.io.*;

public class y19_muzi {
    public int solution(int[] food_times, long k) {
        long time = 0;
        int len = food_times.length;

        int[] temp = new int[len+1];
        int idx = 0;

        for(int i=0; i<len; i++){
            ++time;
            --food_times[i];
            if(food_times[i] != 0) temp[idx++] = i;
        }

        while(idx != 0) {
            int cur = temp[0];
            temp = Arrays.copyOfRange(temp, 1, --idx);

            ++time;
            --food_times[cur];
            if(food_times[cur] != 0) temp[idx++] = cur;
            if(time == k) break;
        }

        return (idx == 0) ? -1 : temp[0];
    }
}
