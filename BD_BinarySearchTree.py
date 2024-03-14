class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None
        
class BinarySearchTree:
    def levelOrder(self,root):
        q = []
        q.append(root)
        q.append(None)
        while len(q):
            node = q.pop(0)
            if node is None:
                if len(q):
                    q.append(None)
                    print()
            else:
                print(node.data,end = "")
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
    
    def inOrder(self,root):
        if root is None:
            return
        self.inOrder(root.left)
        print(root.data)
        self.inOrder(root.right)
                
    def insert(self,root,data):
        if root == None:
            root = Node(data)
            return root
        if data < root.data:
            ## These types of lines are new where we define the value of the current based on the returned value of the subtree
            root.left = self.insert(root.left,data)
        if data > root.data:
            root.right = self.insert(root.right,data)
        ## The return statement at the last tells what to return when both sub left and sub right executions are done
        return root 
         
    def search(self,root,target):
        if root is None:
            return False
        if root.data == target:
            return True
        if target < root.data:
            return self.search(root.left,target)
        if target > root.data:
            return self.search(root.right,target)
    
    def printInRange(self,root,small,big):
        if root is None:
            return
        if root.data > small:
            self.printInRange(root.left,small,big)
        if small <= root.data and root.data <= big:
            print(root.data , end = " ")
        self.printInRange(root.right,small,big)
    
    def delete(self,root,data):
        if root == None:
            return None
        if root.data == data:
            if root.left == None and root.right == None:
                return None
            if root.left == None:
                return root.right
            if root.right == None:
                return root.left
            IS = self.inOrderSuccesor(root.right)
            root.data = IS.data
            root.right = self.delete(root.right,IS.data)
            return root
        if root.data > data:
            root.left = self.delete(root.left,data)
        if root.data < data:
            root.right = self.delete(root.right,data)
        return root
    
    def inOrderSuccesor(self,root):
        if root.left == None:
            return root
        return self.inOrderSuccesor(root.left)
    
    def rToLPaths(self,root,path):
        if root is not None:
            path.append(root.data)
        if root.left is None and root.right is None:
            print(*path,sep="-> ")
            return root.data
        if root.left is not None:
            left = self.rToLPaths(root.left,path)
            path.remove(left)
        if root.right is not None:
            right = self.rToLPaths(root.right,path)
            path.remove(right)
        return root.data
        
arr = [5,1,3,4,2,7]
"""        
           5
         /   \
        1     7
         \
          3
         / \
        2   4
"""
bst = BinarySearchTree()
root = None
for i in arr:
    root = bst.insert(root,i)
# bst.inOrder(root)
# print(bst.search(root,8))
# print("PRINTING IN RANGE ")
# bst.printInRange(root,2,5)
# arr = [5, 1, 3, 4, 2, 7]
# # Insert nodes into the BST
# for i in arr:
#     root = bst.insert(root, i)
# print("Original tree:")
#bst.inOrder(root)
# # Test the delete operation
# delete_values = [3, 5, 1]
# for value in delete_values:
#     print("\nDeleting {}: ".format(value))
#     root = bst.delete(root, value)
#     bst.inOrder(root)
# # Print the final tree after deletions
# print("\nFinal tree:")
# bst.inOrder(root)
bst.rToLPaths(root,[])