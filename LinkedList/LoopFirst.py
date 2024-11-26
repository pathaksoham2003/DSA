# https://leetcode.com/problems/linked-list-cycle-ii/


#  10 -> 20 -> 30 -> 40 -> 50
#        /\                |
#        |                \/
#       90 <- 80 <- 70 <- 60



class Node(object):
    def __init__(self, x):
        self.data = x
        self.next = None

class Solution(object):
    # Type 1 : Using the hash map
    def firstInLoop(self,node):
        temp = node
        memory = {}
        while (temp):
            if temp in memory:
                return memory[temp] 
            else:
                memory[temp] = temp.data
            temp = temp.next
        return None
    # Type 2 : Slow and Fast pointer
    def firstInLoopSf(self,node):
        slow = node
        fast = node
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                slow = node 
                while slow != fast:
                    slow = slow.next
                    fast = fast.next
                return slow.data
        return None
    
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
    fInLoop = solution.firstInLoop(first)
    fInLoopSf = solution.firstInLoopSf(first)
    print(fInLoop)
    print(fInLoopSf)

if __name__ == "__main__":
    main()