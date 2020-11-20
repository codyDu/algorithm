package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


    }


    //    实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。------------------------------------------------------------
//    https://leetcode-cn.com/problems/delete-middle-node-lcci/
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }


//    给你一个单链表的引用结点head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。------------------------------------------------------------
//
//    请你返回该链表所表示数字的 十进制值 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer


    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
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
            if (t > k) {
                slow = slow.next;
            }
            fast = fast.next;
            t++;
        }


        return slow;
    }


//707. 设计链表---------------------------------------------------------------------------------------------------------------

    class MyLinkedList {

        int size;
        ListNode head;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {

            size = 0;
            head = new ListNode(0);

        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {

            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode curr = head;
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {

            if (index > size) return;
            if (index < 0) index = 0;
            ListNode pre = head;
            ListNode add = new ListNode(val);
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            add.next = pre.next;
            pre.next = add;
            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) return;
            ListNode pred = head;
            for (int i = 0; i < index; i++) pred = pred.next;
            pred.next = pred.next.next;
            size--;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */


//回文链表
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<Integer>();

        ListNode curr = head;
        while (curr != null) {
            vals.add(curr.val);
            curr = curr.next;
        }

        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;


    }

//    给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
//
//    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/linked-list-cycle-ii


    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }


//. 相交链表
//    编写一个程序，找到两个单链表相交的起始节点。
//    思路
//    我先走我的路，再走你的路，你先走你的路，再走我的路，这样咱俩走的路程就一样了，速度一样，那么肯定在咱俩两条路的交叉口相遇，并一起走向终点


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }


//    删除链表的倒数第N个节点
//    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }


    //    328. 奇偶链表
//
//    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head; ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return  head;

    }


//    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//             
//
//    示例：
//
//    输入：1->2->4, 1->3->4
//    输出：1->1->2->3->4->4
//
//    链接：https://leetcode-cn.com/problems/merge-two-sorted-lists


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }


    }


//    请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public Node copyRandomList(Node head) {

        return null;
    }



//24. 两两交换链表中的节点

//    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    public ListNode swapPairs(ListNode head) {

            if (head == null || head.next == null) return head;

            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next  = head;
            return newHead;
    }





}
