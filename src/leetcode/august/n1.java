package leetcode.august;

import java.util.*;

public class n1 {
    public boolean detectCapitalUse(String word) {
        boolean first=false, all=true, small=true;
        for(int i=0; i<word.length(); i++){
            int w = word.charAt(i)-'a';
            if(i==0) {
                if(w < 0) first = true; // 대문자(0보다 작으면)
                continue;
            }

            if(first) { // 첫 단어가 대문자라면 뒤에도 다 대문자이거나, 전부 소문자여야한다.
                if(w >= 0) {
                    small &= true; // 소문자
                    all &= false;
                }
                else {
                    all &= true; // 대문자
                    small &= false;
                }
            }else // 대문자가 아니라면 전부 소문자여야한다.
                if(w < 0) small &= false;
        }

        if(word.length() == 1 && first) return true;
        if((first && small && !all) || (first && all && !small) || (!first && small))
            return true;
        else
            return false;
    }
}
