package leetcode.august;

import java.util.ArrayList;
import java.util.Arrays;

public class n13 {
	ArrayList<String> list;
    char[] words;
    char[] ans;
    StringBuilder sb;
    int idx;
    
//    public CombinationIterator(String characters, int combinationLength) {
//        list = new ArrayList<>();
//        words = characters.toCharArray();
//        ans = new char[combinationLength];
//        
//        Arrays.sort(words);
//        getChar(0, 0, combinationLength);
//    }
    
    public void getChar(int start, int cnt, int len) {
        if(cnt == len) {
            sb = new StringBuilder();
            
            for(char w : ans) sb.append(w);
            
            list.add(sb.toString());
            return;
        }
        
        for(int i=start; i<words.length; i++) {
            ans[cnt] = words[i];
            getChar(i+1, cnt+1, len);
        }
    }
    
    public String next() {
        if(idx < list.size()) {
            return list.get(idx++);
        }
        
        return "";
    }
    
    public boolean hasNext() {
        if(idx < list.size()) return true;
        else return false;
    }
}
