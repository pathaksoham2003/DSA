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
       # data = self.head.data
        self.head = self.head.next
        if self.head is None :
            self.tail is None
                

    def __insertLast__(self, data):
        if self.head is None:
            self.__insertFirst__(data)
            # return data
        no = Node(data)
        temp = self.head
        while temp.next is  not None:
            temp = temp.next
        temp.next = no
        # return data
        # self.tail.next = node
        # self.tail = node
        # self.size += 1

    def __deleteLast__(self):
        if self.head.next is None:
            self.__deleteFirst__(self)
            return
        temp1 = self.head
        while temp1.next.next is not None:
            temp1 = temp1.next
        temp1.next = None

        # secondlast = self.get(self.size -2)
        # data = self.tail.data
        # self.tail = secondlast
        # self.tail.next = None
        # self.size -=1
        return 

            

            





l = LinkedList()
l.__insertFirst__(10)
l.__insertFirst__(20)
l.__insertFirst__(30)
l.__insertFirst__(40)
l.__insertLast__(100)
l.__insertLast__(200)
l.__deleteFirst__()
l.__deleteLast__()
l.__rep__()

  
        
