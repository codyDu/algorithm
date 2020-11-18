package com.company;


import java.util.List;

public class Main {

    public static void main(String[] args) {


        binarySearch s = new binarySearch();
        System.out.println();
        System.out.println(
                "123"
        );
	// write your code here
    }

    //翻转链表   递归法
    ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;


        return last;

    }


//    翻转链表 迭代法
    ListNode reverseList2(ListNode head) {

      ListNode pre = null;
      ListNode curr = head;

      while (curr.next != null) {
          ListNode tem = curr.next;
          curr.next = pre;
          pre = curr;
          curr = tem;
      }
      return  pre;

    }

//翻转范围内的链表  递归法
    ListNode tem = null;
    ListNode reverseListN(ListNode head, int n) {

       if (n == 1) {
           tem = head.next;
           return  head;
       }
       ListNode last = reverseListN(head.next, n -1);
       head.next.next = head;
        head.next = tem;
        return last;

    }

    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseListN(head,n);
        }
        head.next = reverseBetween(head,m - 1, n - 1);
        return head;
    }




// 翻转链表   迭代方法   头插法
    public ListNode reverseBetween3(ListNode head, int m, int n) {
      ListNode dummyHead = new ListNode(0);
      dummyHead.next = head;


        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        int setp = 0;
        while (setp < m - 1) {
            g = g.next;
            p = p.next;
            setp ++;
        }

        for (int i = 0 ; i < n - m; i ++ ) {
            ListNode r = p.next;
            p.next = p.next.next;
            r.next = g.next;
            g.next = r;
        }
        return dummyHead.next;
    }


//    输入: d -> 1->2->3->4->5->NULL, m = 3, n = 5
//                 g   p  r

//   d  1  2  5  4  3
//         g  p


//    输出: d -> 1->4->3->2->5->NULL



  





}
