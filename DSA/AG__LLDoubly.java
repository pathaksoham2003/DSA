package DSA.DSA;
    public class AG__LLDoubly {
        Node head;
        public void insertFirst(int val){
            Node node = new Node(val);
            node.next=head;
            node.prev=null;
            if(head!= null){
                head.prev= node;
            }
            head= node;
        }
        public void insertLast(int val){
            Node node = new Node(val);
            Node last = head;
            node.next=null;
            if(head==null){
                head= node;
                node.prev=null;
            }
            while(last.next != null){ // last.next is precaution to get the last element in the LinkedList
                last = last.next;
            }
            last.next = node;
            node.prev=last;
        }
        public void insertAfter(int after,int val){
            Node p = find(after);
            if(p==null){
                System.out.println("after does not exist");
            }
            Node node = new Node(val);
            node.next=p.next;
            p.next = node;
            node.prev=p;
            if(node.next!=null){
                node.next.prev=node;
            }
        }
        public Node find(int val){
            Node node = head;
            while(node != null ){
                if(node.val == val){
                    return node;
                }
                node=node.next;
            }
            return null;
        }
        public void display(){
            Node node = head;
            Node last = null;
            System.out.println(" Print Straight ");
            while(node != null){
                System.out.print(node.val + " <==> ");
                last= node;//node has given its own value to the last named variable and have moved forward in the loop.
                //So when the loop will end, the node named node will give the contents of actual last Node to the varibale named last which is a Node.
                //So at the end of the while loop, the Node named last will actually have the contents of the actual last Node inn the Doubly LinkedList.
                node=node.next;
            }
            System.out.println(" END ");
            System.out.println(" Print in reverse ");
            while(last != null){
                System.out.print(last.val + " <==> ");
                last=last.prev;
            }
            System.out.println(" START ");
        }
        public class Node{  // There is no problem in writing the class inside the upper(AG__LLDoubly) class or outside the upper(AG__LLDoubly) function.
            int val;
            Node next;
            Node prev;
            private Node(int val){
                this.val=val;
            }
            public Node(int val,Node next,Node prev){
                this.val=val;
                this.next=next;
                this.prev=prev;
            }
        }
        public static void main(String[] args){
            AG__LLDoubly list = new AG__LLDoubly();
            list.insertFirst(50);
            list.insertFirst(60);
            list.insertFirst(10);
            list.insertFirst(80);
            list.insertFirst(40);
            list.display();
            list.insertLast(70);
            list.display();
            list.insertAfter(80,90);
            list.display();
        }

    }
