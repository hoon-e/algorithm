package leetcode.july;

import java.io.*;
import java.util.*;

public class n15 {
    public static void main( String[] args ) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = words.length-1; i>=0; i--) {
            if(!words[i].equals("")) sb.append(words[i].replaceAll("\\s", "")).append(" ");
        }

        return sb.toString().trim();
    }
}
