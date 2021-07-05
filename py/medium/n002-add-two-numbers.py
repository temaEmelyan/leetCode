from __future__ import annotations

def lol() -> str:
    return "1"


class LinkedList(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    @staticmethod
    def fromList(l: list) -> LinkedList:
        if len(l) == 0:
            return LinkedList(0)
        node = LinkedList(l[0])
        root = node
        nextIndex = 1
        hasNext = len(l) > 1
        while hasNext:
            node.next = LinkedList(l[nextIndex])

            nextIndex += 1
            node = node.next
            hasNext = len(l) > nextIndex
        return root


class Solution(object):
    @staticmethod
    def addTwoNumbers(l1: LinkedList, l2: LinkedList) -> LinkedList:
        sum = l1.val + l2.val
        root = LinkedList(sum % 10)
        node = root
        hasCarry = sum >= 10

        while (l1.next if l1 else None is not None) or (l2.next if l2 else None is not None) or hasCarry:
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
            carry = 1 if hasCarry else 0
            sum = (l1.val if l1 else 0) + (l2.val if l2 else 0) + carry
            next = LinkedList(sum % 10)
            node.next = next
            node = next
            hasCarry = sum >= 10

        return root

# 111 + 111 = 222
answer = Solution.addTwoNumbers(
    LinkedList.fromList([1, 1, 1]),
    LinkedList.fromList([1, 1, 1])
)
assert answer.val == 2
assert answer.next.val == 2
assert answer.next.next.val == 2
assert answer.next.next.next == None


answer = Solution.addTwoNumbers(LinkedList.fromList(
    [1, 1]), LinkedList.fromList([1, 1, 1]))
assert answer.val == 2
assert answer.next.val == 2
assert answer.next.next.val == 1
assert answer.next.next.next == None


answer = Solution.addTwoNumbers(LinkedList.fromList(
    [0]), LinkedList.fromList([1, 1, 1]))
assert answer.val == 1
assert answer.next.val == 1
assert answer.next.next.val == 1
assert answer.next.next.next == None


answer = Solution.addTwoNumbers(
    LinkedList.fromList([9, 9, 9]),
    LinkedList.fromList([1, 1, 1])
)
assert answer.val == 0
assert answer.next.val == 1
assert answer.next.next.val == 1
assert answer.next.next.next.val == 1
assert answer.next.next.next.next == None
