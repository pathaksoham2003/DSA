package DSA;

public class something {

    public static class Node {
        int data;
        public Node left;
        public Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /*
                1
              /   \
            2       3
          /   \   /   \
         4     5 6     7
 */
    public static Node tree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }
    /*
                2
               / \
              4   5
     */
    public static Node subtree(){
        Node root = new Node(2);
        root.left = new Node(4);
        root.right = new Node(5);
        return root;
    }
    // CHECKING IF THE SUBTREEE EXIST IN A GIVEN TREE OR NOT:-
    public static boolean isSubTree(Node treeRoot , Node subtreeRoot){
        if(treeRoot == null){
            return false;
        }
        if(treeRoot.data == subtreeRoot.data){
            if(isIdentical(treeRoot,subtreeRoot)){
              return true;
            }
        }
       /* We can write ltAns and rtAns in the return statement given below.
        boolean ltAns = isSubTree(treeRoot.left,subtreeRoot);
        boolean rtAns = isSubTree(treeRoot.right,subtreeRoot);
        */


        return isSubTree(treeRoot.left,subtreeRoot) || isSubTree(treeRoot.right , subtreeRoot);
    }
    public static boolean isIdentical(Node treeRoot,Node subtreeRoot){
        if(treeRoot == null && subtreeRoot == null){
            return true;
        }else if(treeRoot == null || subtreeRoot == null || treeRoot.data != subtreeRoot.data){
            return false;
        }
        if(!isIdentical(treeRoot.left,subtreeRoot.left)){
            return false;
        }
        if(!isIdentical(treeRoot.right,subtreeRoot.right)){
            return false;
        }
        return true;
    }
public static void main(String[] args) {
    Node tree = tree();
    Node subtree = subtree();
    System.out.println(isSubTree(tree,subtree));
}
}
