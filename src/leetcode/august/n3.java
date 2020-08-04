package leetcode.august;

import java.util.*;
import java.io.*;

public class n3 {
    // MyCode
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        boolean ans = false;

        for(int i=0; i<s.length(); i++){
            char w = s.charAt(i);
            if(Character.isAlphabetic(w) || Character.isDigit(w))
                sb.append(Character.toLowerCase(w));
        }

        String newString = sb.toString();
        int len = newString.length();

        int half = len/2;
        int fh = half, lh = half+1;

        if(len % 2 == 0) fh = lh = half;

        String f = newString.substring(0, fh);
        String l = new StringBuilder(newString.substring(lh, len)).reverse().toString();

        return (f.equals(l)) ? true : false;
    }

    // Wow..
    public boolean isPalindrome2(String s) {
        // 양옆에서 가져오는 코드
        int start = 0, end = s.length() - 1;
        while (start < end){
            if (!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            } else if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}
