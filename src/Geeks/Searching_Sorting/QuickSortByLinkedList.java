package Geeks.Searching_Sorting;

import java.io.*;
import java.util.*;

public class QuickSortByLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    void addNode(int data){
        if(head == null){
            head = new Node(data);
            return;
        }

        Node curr = head;

        while(curr.next != null)
            curr = curr.next;

        curr.next = new Node(data);
    }

    Node partitionLast(Node start, Node end){
        if(start == end || start == null || end == null)
            return start;

        // pivot이전을 start. 리턴되는 값이다.
        Node prevPivot = start;
        
        // 현재를 start로
        Node curr = start;
        
        // 끝의 데이터를 pivot으로 설정
        int pivot = end.data;

        while(start != end){
            if(start.data < pivot){
                int d = curr.data;
                curr.data = start.data;
                start.data = d;

                // curr를 다음으로 옮긴다.
                curr = curr.next;
            }
            start = start.next;
        }

        int d = curr.data;
        curr.data = end.data;
        end.data = d;

        // start의 값이 리턴된다.
        return prevPivot;
    }

    void quickSort(Node start, Node end){
        if(start == end)
            return;

        Node prevPivot = partitionLast(start, end);

        quickSort(start, prevPivot);

        // start와 pivot이 같다는 소리이다.
        if(prevPivot != null && prevPivot == start )
            quickSort(prevPivot.next, end);
        else if(prevPivot != null && prevPivot.next != null)
            quickSort(prevPivot.next.next, end);
    }

    void printList(Node curr){
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        QuickSortByLinkedList ql = new QuickSortByLinkedList();
        ql.addNode(30);
        ql.addNode(3);
        ql.addNode(4);
        ql.addNode(20);
        ql.addNode(5);

        Node n = ql.head;

        while(n.next != null)
            n = n.next;

        System.out.println("Before Sorting");
        ql.printList(ql.head);
        System.out.println();
        ql.quickSort(ql.head, n);
        System.out.println("After Sorting");
        ql.printList(ql.head);
    }
}
