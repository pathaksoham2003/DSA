package DSA;
public class AJ__CustomStack {
    protected static int[] data;
    private static int DEFAULT_SIZE = 10;
    private static int ptr = -1;
    public AJ__CustomStack(){
        this(DEFAULT_SIZE);
    }
    public AJ__CustomStack(int size){
        this.data = new int[size];
    }
    // USE THE FOLLOWING METHOD TO SEE THE USE CASE OF THE CLASS CUSTOMSTACK. UNCOMMENT THE BELOW METHOD AND COMMENT THE METHOD BELOW THE METHOD GIVEN BELOW.
    /*
   public static void push(int value){
      if(isFull()){
            System.out.println("STACK IS FULL!!");
            return;
        }
        ptr++;
        data[ptr] = value;
    }
    */
    // USE THE FOLLOWING METHOD TO SEE THE USE CASE OF SUBCLASS DYNAMICSTACK. COMMENT THE UPPER METHOD AND UNCOMMENT THE FOLLOWING METHOD.
    public boolean push(int value){
        if(isFull()){
            System.out.println("STACK IS FULL!!!");
        }
        ptr++;
        data[ptr] = value;
        return true;
    }
    public static int pop() throws AK__StackException {
        if(isEmpty()){
            throw new AK__StackException("Stack is Empty");
        }
//        int remove = data[ptr];
//        ptr--;
//        return remove;
//        -----OR DO THIS-----
        return data[ptr--];
    }
    public int peek() throws AK__StackException {
        if(isEmpty()){
            throw new AK__StackException("Cannot find peak in empty stack");
        }
        return data[ptr];
    }
    private static boolean isEmpty() {
        return ptr == -1;
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public static void main(String[] args) throws AK__StackException {
        AJ__CustomStack stack = new AJ__CustomStack();
        stack.push(50);
        stack.push(40);
        stack.push(30);
        stack.push(20);
        stack.push(10);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        // System.out.println(stack.pop());    This will give an exception that we have created, as the stack has become empty
        // System.out.println(stack.peek());   This will give an exception that we have created, as stack is empty.

        // IN THE FOLLOWING STACK THE INITIAL SIZE GIVEN IS 2 BUT STILL IT WAS ABLE TO INSERT 3 ELEMENTS INTO THE STACK.
        // This was possible because we used the Dynamic stack class which copy's the olded array into a new array with the size double as the size of the olded array.
        AL__DynamicStack dstack = new AL__DynamicStack(2);
        dstack.push(100);
        dstack.push(200);
        dstack.push(300);
        System.out.println(dstack.pop());
        System.out.println(dstack.pop());
        System.out.println(dstack.pop());
    }
}
