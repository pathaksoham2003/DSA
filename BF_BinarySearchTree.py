class Node:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

class Info:
    def __init__(self,isValid,min,max,size):
        self.isValid = isValid
        self.min = min
        self.max = max
        self.size = size

class BST:
    
    def BBST(self,arr,start,end):
        if(start>end):
            return None
        mid = (start + end) // 2
        root = Node(arr[mid])
        root.left = self.BBST(arr,start,mid-1)
        root.right = self.BBST(arr,mid+1,end)
        return root
    
    def inOrder(self,root,arr):
        if root is None:
            return None
        self.inOrder(root.left,arr)
        arr.append(root.data)
        self.inOrder(root.right,arr)
    
    def balanceBST(self,root):
        inOrder = self.inOrder(root,[])
        return self.BBST(inOrder,0,len(inOrder)-1)
    
    def largestValid(self,root):
        if root is None:
            return Info(True,None,None,0)
        leftInfo = self.largestValid(root.left)
        rightInfo = self.largestValid(root.right) 
        if root.data < leftInfo.min:
            return Info(False,root.data,root.data)  
        if root.data > rightInfo.max:
            return Info(False)
        if leftInfo.isValid and rightInfo.isValid:
            return Info(True,)
        
        
                
arr = [3,5,6,8,10,11,12]
bst = BST()
root = bst.BBST(arr,0,len(arr)-1)
bst.inOrder(root,[])