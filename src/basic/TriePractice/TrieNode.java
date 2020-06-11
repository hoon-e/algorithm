package basic.TriePractice;

import java.io.*;
import java.util.*;

/*
문자열의 집합을 표현하는 트리를 이야기한다.
각 노드는 <Key, Value> 형태의 맵을 가진다. Key는 하나의 알파벳이고, Value는 그에 해당하는 자식 노드이다.
 */

/*
TrieNode는 자식 노드맵과 현재 노드가 마지막 글자인지의 여부를 가진다.
 */
public class TrieNode {
    // 자식 노드들의 정보
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    // 마지막 글자인지의 여부
    private boolean isLastChar;

    public Map<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public boolean isLastChar() {
        return isLastChar;
    }

    public void setLastChar(boolean isLastChar){
        this.isLastChar = isLastChar;
    }
}
