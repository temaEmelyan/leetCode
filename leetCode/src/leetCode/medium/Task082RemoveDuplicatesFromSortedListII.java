package leetCode.medium;

/*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

*/

import leetCode.ListNode;

public class Task082RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        ListNode listNode = deleteDuplicates(head);

        if (listNode != null) {
            do {
                System.out.println(listNode.val);
                listNode = listNode.next;
            } while (listNode != null);
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode fakeHead = new ListNode(head.val - 1);
        fakeHead.next = head;

        ListNode current = head;
        ListNode previos = fakeHead;
        ListNode next = head.next;

        while (next != null) {
            if (current.val == next.val) {
                ListNode probe = next;
                while (probe != null && probe.val == current.val) {
                    probe = probe.next;
                }
                if (probe == null) {
                    previos.next = null;
                    break;
                } else {
                    previos.next = probe;
                    current = probe;
                    next = current.next;
                }
            }else {
                previos = current;
                current = next;
                next = next.next;

            }
        }

        return fakeHead.next;
    }
}
