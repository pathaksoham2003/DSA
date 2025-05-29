package DSA.DSA;

import java.util.LinkedList;
import java.util.Queue;

public class AN__BinaryTree1 {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    // This is the implementation for a binary tree like this:---
    /* Whenever there is -1, the value stores in the binary tree as per recursion call is null.
    Refer the diagram below to understand this.
    This is the diagram for the int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1,3};
                          1
                2                   3
          4           5       null     6
      null.null.  null.null        null null
     */
   static public class Creation{
       // int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1,3};
        public static int index = -1;
        public static Node create(int[] arr){
            index++;
            if(arr[index]==-1){
                 return null;
            }
            Node newNode = new Node(arr[index]);
            newNode.left = create(arr);
            newNode.right = create(arr);
            return newNode;
        }
       // PREORDER TRIVERSAL IN A BINARY TREE:- We first print the root then we print the entire left subtree, and then we print the entire right subtree.
       public static void preOrder(Node root){ // TIME COMPLEXITY :- O(N)
           if(root==null){
              // System.out.print(" "+ -1 + " "); This statement will print the original array for us.
               return;
           }
           System.out.print(" " + root.data + " ");
           preOrder(root.left);
           preOrder(root.right);
       }
       // POSTORDER TRIVERSAL IN A BINARY TREE:- We first print the left subtree then we print the right subtree and then at the last we print the root.
       // TIME COMPLEXITY = O(N)
        public static void postOrder(Node root){
            if(root==null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
           System.out.print(" "+root.data+" ");
       }
       // LEVEL ORDER TRIVERSAL:- The triversal happens in a layered format. This is a BFS format
        public static void levelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode==null){
                    System.out.println();
                    if(!q.isEmpty()){
                        q.add(null);
                    }else{
                        break;
                    }
                }else{
                    System.out.print( " "+ currNode.data +" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            if(lh>=rh){
                return lh + 1 ;
            }else{
                return rh + 1 ;
            }
        }
        /*
        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;
         */
        public static int numNodes(Node root){
            if(root==null){
                return 0;
            }
       /*
       HE GHE LEFT CHE NODE ADD KAR RIGHT CHE NODES AANI JA STACK MADHE VARTI
       int ln = numNodes(root.left);
       int rn = numNodes(root.right);
       return ln + rn + 1;
        */
            return numNodes(root.left) + numNodes(root.right) + 1;
        }
        // The code below is of diameter of a binary tree with a time complexity of O(n^2).
        public static int diameter2(Node root){
            if(root ==null){
                return 0;
            }
            int leftHt = height(root.left);
            int leftDia = diameter2(root.left);
            int rightHt = height(root.right);
            int rightDia = diameter2(root.right);
            int selfDia = leftHt + rightHt + 1 ;
            return Math.max(selfDia,Math.max(rightDia,leftDia));
        }
        // The code below is of diameter of a binary tree with a time complexity of O(n).
        public static class Info{
            /*
            This class tells how we can use classes to reduce the time complexity of the code. We have return the object of this class in the code below.
            This step will help us store two important values height and diameter from the bottom most recursion call to be carried to the topmost or the uppermost function call.
            Earlier we have to go down twice due to 2 function calls. Once to get the height and second time to get the diameter but this time we go down once and get both the diameter and also the height which is stored inside the object of the class Info.
            Refer the method below this class to see how the object of this class was used.
             */
            int dia;
            int ht;
            public Info(int dia,int ht){
                this.dia = dia;
                this.ht = ht;
            }
        }
        public static Info diameter(Node root){
            if(root == null){
                return new Info(0,0);
            }
            Info left = diameter(root.left);
            Info right = diameter(root.right);

            int ansDia = Math.max(left.dia,Math.max(right.dia,left.ht+right.ht+1));

            return new Info(ansDia,Math.max(left.ht,right.ht)+1); // This info object is enable us to get height and also the diameter from the bottom most function call.
        }
   }
    public static void main(String[] args) {
        int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Creation tree =new Creation();
        Node root = tree.create(arr);
        System.out.println(root.data);
        tree.preOrder(root);
        System.out.println();
        tree.postOrder(root);
        System.out.println();
        tree.levelOrder(root);
        System.out.println(tree.height(root));
        System.out.println(tree.numNodes(root));
        System.out.println(tree.diameter2(root));
        System.out.println(tree.diameter(root).dia);
    }
}