package leetcode.july;

import java.util.*;

public class n30 {
    int len;
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(s.length() >= 100) return ans;

        getWord(s, sb, ans, wordDict);

        return ans;
    }

    private void getWord(String s, StringBuilder sb, List<String> ans, List<String> wordDict) {
        if(s.length() == 0) {
            ans.add(sb.toString());
            return;
        }

        for(String w : wordDict) {
            int idx = s.indexOf(w);
            if(idx == 0){
                String sub = s.substring(idx+w.length(), s.length());

                StringBuilder newSb = new StringBuilder(sb);

                if(sub.length() == 0) newSb.append(w);
                else newSb.append(w).append(" ");

                getWord(sub, newSb, ans, wordDict);
            }
        }
    }
}
