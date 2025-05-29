package DSA.DSA;

public class AM__CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public AM__CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public AM__CustomQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return end == data.length;
    }

    public boolean isEmpty(){
        return end == 0;
    }

    public boolean insert(int value){
        if(isFull()){
            return false;
        }
        data[end] = value;
        end++;
        return true;
    }
    public int remove() throws Exception {
        if(isEmpty()){
            throw new Exception("The Queue is empty");
        }
        int removed = data[0];
        // Shifting the elements to the left
        for(int i = 1; i < end ; i++){
            data[i-1]=data[i];
        }
        end--;
        return removed;
    }
    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }
    public void display(){
        for(int i = 0 ; i<end ; i++){
            System.out.print(" " + data[i] + " <-");
        }
        System.out.println(" END");
    }
    public static void main(String[] args) {
        AM__CustomQueue q = new AM__CustomQueue(3);
        q.insert(10);
        q.insert(20);
        q.insert(30);
        // q.insert(40);   This won't add the element as the size of the array is given 3 in the above constructor.
        q.display();
    }
}