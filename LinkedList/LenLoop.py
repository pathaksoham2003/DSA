

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
    def LenLoop(self,head):
        temp = {}
        node = head
        count = 1
        while node is not None:
            if node not in temp:
                temp[node] = count
            else:
                ans = count - temp[node]
                return ans
            count += 1
            node = node.next
        return None

    # Type 2 : Slow and Fast pointer
    def LenLoopSf(self,head):
        slow = head
        fast = head
        while fast is not None or fast.next is not None:
            slow = slow.next 
            fast = fast.next 
            if fast == slow:
                fast = fast.next
                count = 1
                while fast != slow:
                    count += 1
                    fast = fast.next
                return count
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
    fInLoop = solution.LenLoop(first)
    fInLoopSf = solution.LenLoopSf(first)
    print(fInLoop)
    print(fInLoopSf)

if __name__ == "__main__":
    main()
