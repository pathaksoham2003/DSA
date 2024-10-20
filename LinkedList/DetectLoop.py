# Leetcode : https://leetcode.com/problems/linked-list-cycle/
# Striver : https://takeuforward.org/data-structure/reverse-a-linked-list/


#  10 -> 20 -> 30 -> 40 -> 50
#        /\                |
#        |                \/
#       90 <- 80 <- 70 <- 60

class Node(object):
    def __init__(self, x):
        self.data = x
        self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head is None or head.next is None:
            return False
        first = head 
        second = head.next
        ans = False
        while True:
            if second is None or second.next is None or first == second:
                if first == second:
                    ans = True
                break
            first = first.next
            second = second.next.next
        return ans

def main():
    # Create nodes
    first = Node(10)
    second = Node(20)
    third = Node(30)
    fourth = Node(40)
    fifth = Node(50)
    sixth = Node(60)
    seventh = Node(70)
    eighth = Node(80)
    ninth = Node(90)

    # Link nodes to create the given structure
    first.next = second
    second.next = third
    third.next = fourth
    fourth.next = fifth
    fifth.next = sixth
    sixth.next = seventh
    seventh.next = eighth
    eighth.next = ninth
    ninth.next = second  # Creates the cycle back to the second node (20)

    # Check for a cycle
    solution = Solution()
    has_cycle = solution.hasCycle(first)
    print("Cycle detected:" if has_cycle else "No cycle detected.")

if __name__ == "__main__":
    main()
