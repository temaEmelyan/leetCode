package leetCode.medium;

import leetCode.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Task019 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);

        ListNode listNode1 = removeNthFromEnd(listNode, 1);
    }

//    TODO solve with space complexity O(1)

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode current = head;
        int count = 0;
        while (current != null) {
            map.put(count, current);
            current = current.next;
            count++;
        }


        if (count - n - 1 < 0) {
            return head.next;
        }
        ListNode node = map.get(count - n - 1);


        node.next = node.next.next;

        return head;
    }
}
