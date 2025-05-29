package DSA.DSA;

public class AF__LLSingly {
    Node head;
    Node tail;
    int size;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public AF__LLSingly() {
        this.size = 0;
    }

    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int data) {
        if (tail == null) {
            insertFirst(data);
            return;
        }
        Node node = new Node(data);
        tail.next = node;
        tail = node;
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void insert(int data, int index) {
        if (index == 0) {
            insertFirst(data);
            return;
        }
        if (index == size) { // INSERTLAST MEANS HAME END JAHA LIKHA HAI WAHA INSERT KARNA HAI.
            insertLast(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(data, temp.next);// in this line itself we tell what is the next for the new created node. And put the value as if node is not created yet. If you will imagine that there is a node between then you will endup writing temp.next.next instead of temp.next  Be Careful!
        temp.next = node;
        size++;
    }

    public int deleteFirst() {
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int data = tail.data;
        tail = secondLast;
        tail.next = null;
        size--;
        return data;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) { // for loop madhe jevha i = 0  run hotaee tevha tya loop chya end the aplyala techya next node bhettiee. Meand jevha i =0 for head run hotaee tevha endla aplyala head.next bhettaee.
            // So aplyala samja index paryanta jaychaee tar aplyala techya adhich loop sampvavlagel mhanje to aplya desired index varti jaun thambel.
            node = node.next;
        }
        return node;
    }

    public int delete(int index) {
        if (index == 0) {
            deleteFirst();
        }
        if (index == size - 1) {
            deleteLast();
        }
        Node prev = get(index - 1);
        int data = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return data;
    }

    public static void main(String[] args) {
        AF__LLSingly list = new AF__LLSingly();
        list.insertFirst(10);
        list.insertFirst(20);
        list.display();
        list.insertLast(50);
        list.display();
        list.insertFirst(20);
        list.display();
        list.insert(50, 2);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(1));
        list.display();

        AF__LLSingly second = new AF__LLSingly();
        
    }
}
