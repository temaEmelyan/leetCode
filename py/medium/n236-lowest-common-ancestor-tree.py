from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = int
        self.left = TreeNode | None
        self.right = TreeNode | None


class Solution:
    def lowestCommonAncestor(
        self, root: TreeNode, p: TreeNode, q: TreeNode
    ) -> TreeNode:
        num1 = p.val
        num2 = q.val
        a: list[TreeNode] = self.helper(root, num1)
        b: list[TreeNode] = self.helper(root, num2)
        print(a)
        print(b)

        if len(a) == 1:
            return root
        if len(b) == 1:
            return root
        for i in range(len(a)):
            if 1 + i > len(a) or 1 + i > len(b):
                return a[-i]
            if a[-1 - i] != b[-1 - i]:
                return a[-i]
        return root

    def helper(self, node: TreeNode, num: int) -> List[TreeNode]:
        if node is None:
            return []
        if node.val == num:
            return [node]
        left_result: list[TreeNode] = self.helper(node.left, num)
        if len(left_result) > 0:
            left_result.append(node)
            return left_result
        right_result = self.helper(node.right, num)
        if len(right_result) > 0:
            right_result.append(node)
            return right_result
        return []


def find_last_common(a: list[int], b: list[int]) -> int:
    if len(a) == 1:
        return a[0]
    if len(b) == 1:
        return b[0]
    for i in range(len(a) + 1):
        if (1 + i) > len(a) or (1 + i) > len(b):
            return a[-i]
        if a[-1 - i] != b[-1 - i]:
            return a[-i]
    raise RuntimeError("should never happen")


assert find_last_common([5, 3], [4, 2, 5, 3]) == 5
assert find_last_common([4, 3, 2, 1], [2, 1]) == 2
assert find_last_common([4, 2, 5, 3], [5, 3]) == 5
assert find_last_common([4, 3, 2, 1], [1]) == 1
assert find_last_common([4, 3, 2, 1], [6, 5, 2, 1]) == 2
assert find_last_common([4, 3, 2, 1], [10, 9, 8, 7, 6, 5, 2, 1]) == 2
assert find_last_common([10, 9, 8, 7, 6, 5, 2, 1], [4, 3, 2, 1]) == 2
assert find_last_common([10, 9, 8, 7, 6, 5, 2, 1], [40, 30, 20, 1]) == 1
assert find_last_common([10, 9, 8, 7, 6, 5, 2, 1], [11, 9, 8, 7, 6, 5, 2, 1]) == 9
assert find_last_common([10, 9, 8, 7, 6, 5, 2, 1], [5, 2, 1]) == 5
print("PASS")
