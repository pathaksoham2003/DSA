class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
class BST:
    def inOrder(self,root):
        if root is None:
            return
        self.inOrder(root.left)
        print(root.data)
        self.inOrder(root.right)
    ## This is a very important technique but the code is WRONG
    def validBSTWrongCode(self,root):
        if root is None:
            return True
        # Here we check if the left is not None only then we evaluate the left and root comparison
        if root.left is not None and root.data <= root.left.data:
            return False
        # Similarly here we check right is not None only then we evaluate the right and root comparison
        if root.right is not None and root.data >= root.right.data:
            return False
        return self.validBST(root.left) and self.validBST(root.right)
    ## Refer the ALPHA video for this & Another way is to ge the inorder traversal and see if it's sorted
    def validBST(self,root,min,max):
        ## Important to understand that every node data should be 
        # greater than the maximum of the left node and 
        # the minimum of the right sub tree
        ## Or we can also say that 
        # all the elements in the left subtree should be less than the root
        # all the elements in the right subtree should be more than the root
        if root is None:
            return True
        if max is not None and root.data >= max.data: 
            return False
        if min is not None and root.data <= min.data: 
            return False
        return self.validBST(root.left,min,root) and self.validBST(root.right,root,max)
    
    def mirror(self,root):
        if root is None:
            return None
        leftST = self.mirror(root.left)
        rightST = self.mirror(root.right)
        root.left = rightST
        root.right = leftST
        return root
        
root1 = TreeNode(2)
root1.left = TreeNode(1)
root1.right = TreeNode(3)
bst1 = BST()
print("Test Case 1:", bst1.validBST(root1,None,None))  # Should print True

# Test Case 2: Invalid BST
root2 = TreeNode(5)
root2.left = TreeNode(1)
root2.right = TreeNode(4)
root2.right.left = TreeNode(3)
root2.right.right = TreeNode(6)
bst2 = BST()
print("Test Case 2:", bst2.validBST(root2,None,None))  # Should print False

# Test Case 3: Valid BST
root3 = TreeNode(10)
root3.left = TreeNode(5)
root3.right = TreeNode(15)
root3.right.left = TreeNode(12)
root3.right.right = TreeNode(20)
bst3 = BST()
print("Test Case 3:", bst3.validBST(root3,None,None))  # Should print True
bst3.inOrder(root1)
print(bst3.mirror(root1))
bst3.inOrder(root1)