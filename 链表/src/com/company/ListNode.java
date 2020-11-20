package com.company;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
