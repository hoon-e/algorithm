package Programmers.hash;

import java.io.*;
import java.util.*;

import java.util.*;

public class phonebook{
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            List<String> phones = new ArrayList<String>();

            Arrays.sort(phone_book);

            for(String s : phone_book){
                if(phones.size() == 0){
                    phones.add(s);
                }else{
                    for(String key : phones){
                        if(s.contains(key))
                        {
                            return answer = false;
                        }
                    }
                    phones.add(s);
                }
            }

            return answer;
        }
    }
}
