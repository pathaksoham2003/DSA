class Info:
    def __init__(self,height,diameter):
        self.height = height
        self.diameter = diameter

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def insert(self):
        self.left = Node(20)
        self.right = Node(30)

    def preOrder(self, node):
        if node is None:
            return
        print(node.data)
        self.preOrder(node.left)
        self.preOrder(node.right)

    def postOrder(self,root):
        if root is None:
            return
        self.postOrder(root.left)
        self.postOrder(root.right)
        print(root.data)

    def inOrder(self,root):
        if root is None:
            return
        self.inOrder(root.left)
        print(root.data)
        self.inOrder(root.right)

    def numNodes(self,root):
        if root is None:
            return 0
        return self.numNodes(root.left) + self.numNodes(root.right) + 1
    
    def maxHeight(self,root):
        if root == None:
            return 0
        return max(self.maxHeight(root.left),self.maxHeight(root.right)) + 1
    
    def maxDiameter(self,root):
        if root is None:
            return 0
        currentDia = self.maxHeight(root.left) + self.maxHeight(root.right) + 1
        leftDia = self.maxDiameter(root.left)
        rightDia = self.maxDiameter(root.right)
        return max(currentDia,leftDia,rightDia)
    
    def maxDiaWithObj(self,root):
        if root is None:
            return Info(0,0)
        leftInfo = self.maxDiaWithObj(root.left)
        rightInfo = self.maxDiaWithObj(root.right)
        return Info(max(leftInfo.height,rightInfo.height)+1,max(leftInfo.diameter,rightInfo.diameter,leftInfo.height+rightInfo.height+1))
    
    def levelOrder(self,root):
        q = []
        q.append(root)
        q.append(None)
        while len(q):
            node = q.pop(0) 
            if node is None:
                if len(q):
                    q.append(None)
            else:
                print(node.data)
                if(node.left):
                    q.append(node.left)
                if(node.right):
                    q.append(node.right)
    
    def kLevOrder(self,root,k):
        q = []
        count = 0
        q.append(root)
        q.append(None)
        while len(q):
            node = q.pop(0) 
            if node is None:
                if len(q):
                    count = count + 1
                    q.append(None)
            else:
                if count == k: 
                    print(node.data)
                if(node.left):
                    q.append(node.left)
                if(node.right):
                    q.append(node.right)
        
# Create the root node with a value of 10
# Create a binary tree with the root node
root_object = Node(10)
# Insert nodes with values 20 and 30 as left and right children of the root
root_object.insert()
print("PRE ORDER TRAVERSAL")
# Display the binary tree
root_object.preOrder(root_object)
print("POST ORDER TRAVERSAL")
root_object.postOrder(root_object)
print("IN ORDER TRAVERSAL")
root_object.inOrder(root_object)
print("LEVEL ORDER TRAVERSAL")
root_object.levelOrder(root_object)
print("NUMBER OF NODES")
print(root_object.numNodes(root_object))
print("MAX HEIGHT")
print(root_object.maxHeight(root_object))
print("MAX DIAMETER")
print(root_object.maxDiameter(root_object))
print("MAX DIAMETER WITH OBJECT")
print("HEIGHT : ",root_object.maxDiaWithObj(root_object).height)
print("DIAMETER : ",root_object.maxDiaWithObj(root_object).diameter)
print("K LEVEL TRAVERSAL")
root_object.kLevOrder(root_object,1)
