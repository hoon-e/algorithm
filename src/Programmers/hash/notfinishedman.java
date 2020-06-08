package Programmers.hash;

import java.io.*;
import java.util.*;

public class notfinishedman {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> parts = new HashMap<>();

            for(String p : participant){
                if(parts.get(p) == null)
                    parts.put(p, 1);
                else{
                    int num = parts.get(p);
                    parts.put(p, ++num);
                }
            }

            for(String c : completion){
                if(parts.get(c) > 0){
                    int num = parts.get(c);
                    parts.put(c, --num);
                }
            }

            Iterator<String> keys = parts.keySet().iterator();

            while(keys.hasNext()){
                String key = keys.next();

                if(parts.get(key) != 0)
                    answer = key;
            }

            return answer;
        }
    }
}
