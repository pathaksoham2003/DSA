class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class Info:
    def __init__(self, node, hd=0):
        self.node = node
        self.hd = hd

class BinaryTree:
    def checkSubTree(self, Tree, subTree):
        if Tree == None and subTree == None:
            return True
        if Tree == None or subTree == None:
            return False
        if Tree.data == subTree.data:
            return self.checkSubTree(Tree.left, subTree.left) and self.checkSubTree(
                Tree.right, subTree.right
            )
        else:
            return self.checkSubTree(Tree.left, subTree) or self.checkSubTree(
                Tree.right, subTree
            )

    def topView(self, root):
        if root == None:
            return
        q = []
        m = dict()
        hd = 0
        rootInfo = Info(root)
        q.append(rootInfo)
        while len(q):
            root = q[0]
            hd = root.hd
            if hd not in m:
                m[hd] = root.node.data
            if root.node.left:
                leftInfo = Info(root.node.left, hd - 1)
                q.append(leftInfo)
            if root.node.right:
                rightInfo = Info(root.node.right, hd + 1)
                q.append(rightInfo)
            q.pop(0)
        for i in sorted(m):
            print(m[i], end=" ")
    
    def findPath(self,root,n):
        if root is None:
            return []
        if root.data == n:
            return [n]
        leftPath = self.findPath(root.left,n)
        if len(leftPath) != 0:
            ## If yo want the new create list use the below and not list.append(x)
            ## list.append(x) does not return a new list
            return leftPath + [root.data]
        rightPath = self.findPath(root.right,n)
        if len(rightPath) != 0:
            return rightPath + [root.data]
        return []
    
    def findLCA1(self,root,n1,n2):
        pathOne = self.findPath(root,n1)
        pathTwo = self.findPath(root,n2)
        print(pathOne)
        print(pathTwo) 
        for i in range(0,min(len(pathOne),len(pathTwo))):
            if pathOne[i] == pathTwo[i]:
                return pathOne[i]
        return -1
        
    def findLCA2(self,root, n1, n2):
        if root is None:
            return None
        if root.data == n1 or root.data == n2:
            return root
        left_lca = self.findLCA2(root.left, n1, n2)
        right_lca = self.findLCA2(root.right, n1, n2)
        if left_lca and right_lca:
            return root
        return left_lca if left_lca is not None else right_lca
    
    def minDistance(self,root,n1,n2):
        global ans
        if root is None:
            return -1
        if root.data == n1 or root.data == n2:
            return 1
        ld = self.minDistance(root.left,n1,n2)
        rd = self.minDistance(root.right,n1,n2)
        if ld != -1 and rd != -1:
            ans = ld + rd
            return ld + rd + 1
        if ld == -1 and rd != -1:
            return rd
        if ld != -1 and rd == -1:
            return ld
        return -1
    
    def findKthAnsec(self,root,n,k):
        if root is None:
            return -1
        if root.data == n:
            return k - 1
        lk = self.findKthAnsec(root.left,n,k)
        rk = self.findKthAnsec(root.right,n,k)
        if lk == 0 or rk == 0:
            print(root.data)
        if lk == -1 and rk == -1:
            return -1
        if lk == -1:
            return rk - 1
        else:
            return lk - 1
    def toSumTree(self,root):
        if root is None:
            return 0
        ls = self.toSumTree(root.left)
        rs = self.toSumTree(root.right)
        oldData = root.data
        root.data = ls + rs
        return oldData + root.data ## oldData + newData
        
    def levelOrder(self,root):
        q = []
        q.append(root)
        q.append(None)
        print("Start Printing")
        while(len(q)):
            node = q.pop(0)
            if node is None:
                if len(q):
                    q.append(None)
                    print()
            else:
                print(node.data,end=" ")
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        
ob = BinaryTree()
root1 = Node(6)
root1.left = Node(4)
root1.right = Node(10)
root1.left.left = Node(3)
root1.left.right = Node(5)
"""
         6
       /   \
      4     10
     / \    
    3   5     
"""
root2 = Node(4)
root2.left = Node(3)
root2.right = Node(5)
print(ob.checkSubTree(root1, root2))
ob.topView(root1)
""" Create following Binary Tree
         1
        / \
       2   3
        \
         4
          \
           5
            \
             6
    """
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.right = Node(4)
root.left.right.right = Node(5)
root.left.right.right.right = Node(6)
print("\nThe top view of the tree is: ")
ob.topView(root)
print("\nCOMMON ANCESTOR 1 ")
print(ob.findLCA1(root1,5,3))
print("\nCOMMON ANCESTOR 2 ")
print(ob.findLCA2(root1,10,3).data)
## COVER OTHER WAYS TO IMPLEMENT LCA
print(ob.findPath(root,6))
print("MINIMUM DISTANCE ")
print(ob.minDistance(root1,5,3))
print(ans)
ob.findKthAnsec(root,6,3)
"""
             10
          /      \
        -2        6
       /   \     /  \
     8     -4   7    5
"""
tree = Node(10)
tree.left = Node(-1)
tree.right = Node(6)
tree.left.left = Node(8)
tree.left.right = Node(-4)
tree.right.left = Node(7)
tree.right.right = Node(5)
ob.toSumTree(tree)
ob.levelOrder(tree)