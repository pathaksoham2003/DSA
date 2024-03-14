class Node:
    def __init__(self,data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None
    def __rep__(self):
        node = self.head
        while node is not None:
            print(str(node.data) + " -> ")
            node = node.next
        print("Null")

    def __insertFirst__(self,data):
        node = Node(data)
        if self.head is None:
            self.head = node
        else:
            node.next = self.head
            self.head = node
    
    def __deleteFirst__(self):
        self.head = self.head.next



a = LinkedList()
a.__insertFirst__(10)
a.__insertFirst__(20)
a.__deleteFirst__()
a.__insertFirst__(30)
a.__rep__()

  
        
