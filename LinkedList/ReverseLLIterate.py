# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def reverseList(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        if head is None or head.next is None:
            return head
        temp = head
        prev = None
        normal = head 
        future = head.next
        while future is not None:
            normal.next = prev
            prev = normal
            normal = future
            future = future.next
        normal.next = prev
        return normal
        