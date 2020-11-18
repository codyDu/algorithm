package com.company;

public class Main {

    public static void main(String[] args) {




    }


//    实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
//    https://leetcode-cn.com/problems/delete-middle-node-lcci/
    public void deleteNode(ListNode node) {

       node.val = node.next.val;
       node.next = node.next.next;

    }



//    给你一个单链表的引用结点head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//
//    请你返回该链表所表示数字的 十进制值 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer


    public int getDecimalValue(ListNode head) {
        int res = 0;
        while(head != null){
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;


    }


//    输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public ListNode getKthFromEnd(ListNode head, int k) {

       ListNode slow = head;
       ListNode fast = head;
        int t = 0;
        while (fast != null) {
            if (t>k) {
                slow = slow.next;
            }
            fast = fast.next;
            t++;
        }


        return slow;
    }













}
