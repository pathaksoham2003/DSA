package DSA;
    public class AH__LLCircular {
        private Node head;
        private Node tail;
        public AH__LLCircular(){
            this.head=null;
            this.tail=null;
        }
        public void insert(int val){
            Node node = new Node(val);
            if(head==null){
                head=node;
                tail=node;
            }
            tail.next=node;
            node.next= head;
            tail= node;
        }
        public void delete(int val){
            Node node = head;
            if(node == null){
                return;
            }
            if(node.val==val){
                head = head.next;
                tail.next=head;
                return;
            }
            do{
                Node n = node.next;
                if(n.val==val){
                    node.next=n.next;
                    break;
                }
                node=node.next;
            }while(node != head);
        }
        public void display(){
            Node node =head;
            if(head!=null){
                do{
                    System.out.print(node.val+ " --> ");
                    node = node.next;
                } while(node != head);
                System.out.println(" HEAD ");
            }
        }
        public class Node{
            int val;
            Node next;
            public Node(int val){
                this.val=val;
            }
        }
        public static void main(String[] args){
            AH__LLCircular list = new AH__LLCircular();
            list.insert(23);
            list.insert(25);
            list.insert(40);
            list.insert(80);
            list.display();
            list.delete(80);
            list.delete(23);
            list.display();
        }
    }
