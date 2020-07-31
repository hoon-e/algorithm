package leetcode.july;

import java.util.*;

public class n28 {
    private int getFrequent(int[] frq, int[] idle) {
        int maxFrq = -1;
        int isIdle = -1;

        for(int i = 0; i < 26; i++) {
            // frq가 제일 크고, idle 상태이지 않은 것을 선택하고, idle 횟수를 n만큼 올린다.
            if(maxFrq < frq[i] && frq[i] != 0 && idle[i] != 0) {
                maxFrq = frq[i];
                isIdle = i;
            }
        }

        if(isIdle != -1) return isIdle;

        for(int i=0; i < 26; i++) {
            if(frq[i] > 0) return -2;
        }

        return -3;
    }

    public int leastInterval(char[] tasks, int n) {

        if(n == 0) return tasks.length;
        int[] frq = new int[26];  // 해당 알파벳의 남은 갯수
        int[] idle = new int[26]; // 해당 알파벳이 회전중인가
        int evt;
        int time = 0;

        for(char t : tasks) // 알파벳 갯수 세기
            ++frq[t-'A'];

        evt = getFrequent(frq, idle);

        while( evt != -3 ){
            if(evt == -2) {
                ++time;
                for(int i=0; i<26; i++) {
                    if (idle[i] > 0) --idle[i];
                }
            } else {
                for(int i=0; i<26; i++) {
                    if( idle[i] > 0 ) --idle[i];
                }
                ++time;
                --frq[evt];
                idle[evt] = n;
            }

            evt = getFrequent(frq, idle);
        }

        return time;
    }
}

    /*
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(char task : tasks)
            ++freq[task-'A'];

        Arrays.sort(freq);

        int max = freq[25] - 1;
        int idle = n * max;

        for(int i = 24; i >= 0; i-- )
            idle -= Math.min(freq[i], max);

        return ( 0 < idle ) ? tasks.length + idle : tasks.length;
    }
    */