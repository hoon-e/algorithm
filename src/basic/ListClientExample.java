package basic;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * interface는 메서드의 집합을 의미한다.
 * compareTo() 메서드 구현시 삼항 연산자 ? 를 주로 사용한다.
 */
public class ListClientExample {
    private List list;

    public ListClientExample(){
        list = new LinkedList();
    }

    private List getList(){
        return list;
    }

    public static void main(String[] args){
        ListClientExample lce = new ListClientExample();
        List list = lce.getList();
        System.out.println(list);
    }
}
