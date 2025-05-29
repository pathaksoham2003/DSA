package DSA.DSA;

import java.util.*;

public class AN__BinaryTree2 {

    // int[] arr = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1,3};
    public static int index = -1;

    public static Node create(int[] arr) {
        index++;
        if (arr[index] == -1) {
            return null;
        }
        Node newNode = new Node(arr[index]);
        newNode.left = create(arr);
        newNode.right = create(arr);
        return newNode;
    }

    // LEFT VIEW :
    // https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=25
    public static void leftView(Node root, int currentLevel, ArrayList<Integer> arl) {
        if (root == null) {
            return;
        }
        if (arl.size() < currentLevel) {
            arl.add(root.data);
            System.out.println(root.data);
        }
        leftView(root.left, currentLevel + 1, arl);
        leftView(root.right, currentLevel + 1, arl);
    }

    // RIGHT VIEW :
    // https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=25
    public static void rightView(Node root, int currentLevel, ArrayList<Integer> arl) {
        if (root == null) {
            return;
        }
        if (arl.size() < currentLevel) {
            arl.add(root.data);
            System.out.println(root.data);
        }
        leftView(root.right, currentLevel + 1, arl);
        leftView(root.left, currentLevel + 1, arl);
    }

    // https://www.youtube.com/watch?v=0FtVY6I4pB8&t=289s
    // A queue is defined using a linkedinList remember this
    // Use the Tree map for sorted order of the keys in the map
    // TC : O(N)
    // SC : O(N)

    public static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -1, -1, 3, 4, -1, -1, 5, -1, -1};
        AN__BinaryTree2 obj = new AN__BinaryTree2();
        index = -1;
        Node root = obj.create(arr);
        ArrayList<Integer> arl = new ArrayList<>();
        System.out.println("Left View : ");
        leftView(root, 1, arl);
        ArrayList<Integer> ar = new ArrayList<>();
        System.out.println("Right View : ");
        rightView(root, 1, ar);
        obj.bottomView(root);


        int[] arr1 = {1, 2, 3, -1, -1, 4, -1, -1, 2, 4, -1, -1, 3, -1, -1};
        // Tree:
        //       1
        //     /   \
        //    2     2
        //   / \   / \
        //  3   4 4   3
        int[] arr2 = {1, 2, -1, 3, -1, -1, 2, -1, 3, -1, -1};
        index = -1;
        Node rootOne = obj.create(arr1);
        System.out.println(obj.isSymmetric(rootOne));
        index = -1;
        Node rootTwo = obj.create(arr2);
        System.out.println(obj.isSymmetric(rootTwo));
        index = -1;
        ArrayList<Integer> temp = new ArrayList<>();
        System.out.println(obj.getPath(root, 4, temp));
        System.out.println(temp);
        index = -1;
        System.out.println(obj.commonAncestor(root, 4, 3));
        index = -1;
        int[] child = {40, 10, 2, -1, -1, 5, -1, -1, 20, 30, -1, -1, 40, -1, -1};
        Node childrenProp = obj.create(child);
        obj.makeChildrenSum(childrenProp);
        obj.levelOrder(childrenProp);
        index = -1;
        int[] distanceKArr = {10,20,40,-1,-1,50,-1,-1,30,60,-1,-1,70,-1,-1};
        Node distanceKRoot = obj.create(distanceKArr);
        List<Integer> tempAns = obj.distanceK(distanceKRoot,distanceKRoot.left,3);
        System.out.println(tempAns);

    }

    // COMMON ANCESTOR :
    // https://www.youtube.com/watch?v=_-QHfMDde90&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=27
    public int commonAncestor(Node root, int a, int b) {
        if (root == null) return -1;

        if (root.data == a) return a;

        if (root.data == b) return b;

        int leftAns = commonAncestor(root.left, a, b);
        int rightAns = commonAncestor(root.right, a, b);

        if (leftAns != -1 && rightAns != -1) {
            return root.data;
        }
        if (leftAns != -1) {
            return leftAns;
        } else {
            return rightAns;
        }
    }


    // helper function for the distanceK
    public void createParent(Node root, Map<Node, Node> parent_track) {
        if (root == null) return;
        if (root.left != null) {
            parent_track.put(root.left, root);
            createParent(root.left, parent_track);
        }
        if (root.right != null) {
            parent_track.put(root.right, root);
            createParent(root.right, parent_track);
        }
    }
    // Print all the Nodes at a distance of K
    // https://www.youtube.com/watch?v=i9ORlEy6EsI&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=30
    public List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> parent_track = new HashMap<>();
        createParent(root, parent_track);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(target);
        visited.put(target,true);
        int size;
        while (!q.isEmpty()) {
            if(level == k) break;
            level += 1;
            size = q.size();
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                if(current.left != null && visited.get(current.left)==null) {
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right != null && visited.get(current.right) ==null) {
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                if(parent_track.get(current) != null && visited.get(parent_track.get(current))==null) {
                    q.offer(parent_track.get(current));
                    visited.put(parent_track.get(current),true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            Node curr = q.poll();
            ans.add(curr.data);
        }
        return ans;
    }

    // MINIMUM TIME TAKE TO BURN A TREE :
    // https://www.youtube.com/watch?v=2r5wLmQfD6g&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=31
    // burn is also level - 1
    public int burnTree(Node root , Node target) {
        Map<Node,Node> parent_track = new HashMap<>();
        createParent(root,parent_track);
        int maxi = 0;
        int level = 0;
        Queue<Node> q = new LinkedList<>();
        Map<Node,Boolean> visited = new HashMap<>();
        q.add(target);
        visited.put(target,true);
        while(!q.isEmpty()) {
            int size = q.size();
            level += 1;
            int fl = 0;
            for(int i = 0 ; i < size ; i++) {
                Node current = q.poll();
                if(current.left != null && !visited.get(current.left)) {
                    fl = 1;
                    q.add(current.left);
                    visited.put(current.left,true);
                }
                if(current.right != null && !visited.get(current.right)) {
                    fl = 1;
                    q.add(current.right);
                    visited.put(current.right,true);
                }
                if(parent_track.get(current) != null && !visited.get(parent_track.get(current))) {
                    fl = 1;
                    q.add(parent_track.get(current));
                    visited.put(parent_track.get((current)),true);
                }
            }
            if(fl == 1 ) maxi++;
        }
        return maxi;
    }

    // BOTTOM VIEW :
    // https://www.youtube.com/watch?v=0FtVY6I4pB8&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=24
    public void bottomView(Node root) {
        Queue<Info> q = new LinkedList<Info>();
        Info i = new Info(0, root);
        q.add(i);
        Map<Integer, Integer> hm = new TreeMap<Integer, Integer>();
        while (!q.isEmpty()) {
            Info info = q.remove();
            if (info.node.left != null) {
                Info inl = new Info(info.position - 1, info.node.left);
                q.add(inl);
            }
            if (info.node.right != null) {
                Info inr = new Info(info.position + 1, info.node.right);
                q.add(inr);
            }
            hm.put(info.position, info.node.data);
        }
        System.out.println(hm);
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // SYMMETRIC :
    // https://www.youtube.com/watch?v=nKggNAiEpBE&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=25
    public boolean isSymmetric(Node root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(Node left, Node right) {
        if (left == null || right == null) return left == right;
        if (left.data != right.data) return false;
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    // GET PATH :
    // https://www.youtube.com/watch?v=fmflMqVOC7k&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=27
    public boolean getPath(Node root, int target, ArrayList<Integer> arr) {
        if (root == null) return false;
        arr.add(root.data);
        if (root.data == target) return true;
        if (getPath(root.left, target, arr) || getPath(root.right, target, arr)) return true;
        arr.removeLast();
        return false;
    }

    // MINIMUM WIDTH :
    // https://www.youtube.com/watch?v=ZbybYvcVLks&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=28


    // CHILDREN SUM PROPERTY :
    // https://www.youtube.com/watch?v=fnmisPM6cVo&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=29
    public void makeChildrenSum(Node root) {
        if (root == null) return;
        int children = 0;
        if (root.left != null) {
            children += root.left.data;
        }
        if (root.right != null) {
            children += root.right.data;
        }
        if (children >= root.data) {
            root.data = children;
        } else {
            if (root.left != null) root.left.data = root.data;
            else if (root.right != null) root.right.data = root.data;
        }
        makeChildrenSum(root.left);
        makeChildrenSum(root.right);
        int tot = 0;
        if (root.left != null) tot += root.left.data;
        if (root.right != null) tot += root.right.data;
        if (root.left != null || root.right != null) root.data = tot;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    class Info {
        int position;
        Node node;

        public Info(int position, Node node) {
            this.position = position;
            this.node = node;
        }
    }
}