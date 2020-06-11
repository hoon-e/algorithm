package basic.TriePractice;

import java.io.*;
import java.util.*;

public class Trie {
    // 루트 노드 => 빈 문자열을 가진다.
    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    /*
        1. 단어 정보를 저장
        2. 해당 단어가 존재하는지 확인
        3. 특정 단어를 삭제
     */

    void insert(String word){
        TrieNode curNode = this.root;

        for(int i=0; i<word.length(); i++){
            curNode = curNode.getChildNodes()
                    .computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        curNode.setLastChar(true);
    }
    
    /*
        특정 단어가 Trie에 존재하는지 확인하기 위해서
        1. 루트 노드 부터 순서대로 알파벳이 일치하는 자식노드들이 존재할 것
        2. 해당 단어의 마지막 글자에 해당하는 노드의 isLastChar가 true일 것
     */

    boolean contains(String word){
        TrieNode curNode = this.root;

        for(int i=0; i<word.length(); i++){
            char curChar = word.charAt(i);
            TrieNode node = curNode.getChildNodes().get(curChar);

            if(node == null)
                return false;

            curNode = node;
        }
        
        // 겹치는 마지막 단어가 boolean 체크가 되어있지 않다면, Trie에 단어가 존재하지 않는 것
        return curNode.isLastChar();
    }

    /*
        delete
        contains 메소드처럼 주어진 단어를 찾아 하위 노드로 단어 길이만큼 탐색
        하위 노드로 내려가면서, 삭제 대상 단어를 탐색하고, 다시 올라오며 삭제하는 과정으로 구현되어야 한다.

        1. 자식 노드를 가지고 있지않아야 한다.
        2. 삭제를 시작하는 첫 노드는 isLastChar가 True여야 한다.
        3. 삭제를 진행하는 중에는 isLastChar가 false여야 한다.

        탐색 : 부모 -> 자식
        삭제 : 자식 -> 부모
     */

    void delete(String word){
        delete(this.root, word, 0);
    }

    private void delete(TrieNode curNode, String word, int index){
        char curChar = word.charAt(index);

        // 아예 없는 단어일 경우 에러 출력
        if(!curNode.getChildNodes().containsKey(curChar))
            throw new Error("There is no [ " + word + " ] in this Trie.");

        TrieNode childNode = curNode.getChildNodes().get(curChar);
        ++index;

        if(index == word.length()){
            // 같은 노드는 존재하나, 마지막 단어를 포함하지 않는 경우 => 해당 단어는 존재하지 않는다.
            if(!childNode.isLastChar())
                throw new Error("There is no[ " + word + " ] in this Trie.");

            childNode.setLastChar(false);

            // 삭제 대상 언어의 제일 끝으로서 자식 노드가 없다면 삭제를 시작한다.
            if(childNode.getChildNodes().isEmpty())
                childNode.getChildNodes().remove(curChar);
        }else{
            delete(childNode, word, index);

            // 삭제 중에, 자식 노드가 없고 현재 노드로 끝나는 다른 단어가 없는 경우 이 노드를 삭제한다.
            if(!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
                childNode.getChildNodes().remove(curChar);
        }
    }

    boolean isRootEmpty(){
        return this.root.getChildNodes().isEmpty();
    }
}
