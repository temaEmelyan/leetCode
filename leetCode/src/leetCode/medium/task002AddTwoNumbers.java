package leetCode.medium;

/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

//  Definition for singly-linked list.


import leetCode.ListNode;

public class task002AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);

        ListNode listNode = addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode output = new ListNode(0);
        ListNode temp = output;

        int a = 0, b = 0;

        while (true) {
            a = l1 == null ? 0 : l1.val;
            b = l2 == null ? 0 : l2.val;

            temp.val = (a + b + carry) % 10;

            carry = (a + b + carry) / 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 == null && l2 == null) {
                if (carry > 0) {
                    temp.next = new ListNode(carry);
                }
                break;
            } else {
                temp.next = new ListNode(0);
                temp = temp.next;
            }
        }

        return output;
    }

    public ListNode addTwoNumbersBadTimeComplexity(ListNode l1, ListNode l2) {
        int i = 0;

        ListNode tmpNode1 = l1;
        ListNode tmpNode2 = l2;

        boolean contin = true;
        long l1Int = 0;
        long l2Int = 0;

        while (contin) {
            l1Int += tmpNode1.val * (int) Math.pow(10, i);
            i++;
            if (tmpNode1.next != null) {
                tmpNode1 = tmpNode1.next;
            } else {
                contin = false;
            }
        }

        contin = true;
        i = 0;

        while (contin) {
            l2Int += tmpNode2.val * (int) Math.pow(10, i);
            i++;
            if (tmpNode2.next != null) {
                tmpNode2 = tmpNode2.next;
            } else {
                contin = false;
            }
        }

        long res = l1Int + l2Int;

        ListNode result = new ListNode((int) (res % 10));
        ListNode tmpNodeRes = result;
        res = res / 10;

        while (res > 0) {
            tmpNodeRes.next = new ListNode((int) (res % 10));
            res = res / 10;
            tmpNodeRes = tmpNodeRes.next;
        }
        return result;


    }
}