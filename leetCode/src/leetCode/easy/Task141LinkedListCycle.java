package leetCode.easy;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Task141LinkedListCycle {


    public static void main(String[] args) {

    }


    private static boolean hasCycle(ListNode head) {
        ListNode turtle, hare;

        turtle = hare = head;

        if (head == null || head.next == null) {
            return false;
        }

        while (true) {
            if (hare.next == null || hare.next.next == null) {
                return false;
            }

            hare = hare.next.next;
            turtle = turtle.next;

            if (turtle.val == hare.val) {
                return true;
            }
        }
    }
}
