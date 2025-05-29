package DSA.DSA;

public class AL__DynamicStack extends AJ__CustomStack {

    public AL__DynamicStack(){
        super();
    }
    public AL__DynamicStack(int size){
        super(size);
    }
    @Override
    public boolean push(int item){
        if(this.isFull()) {
            int[] temp = new int[data.length * 2];  //Creating an empty array of size double the old array.
            // Copy all the previous items of old array into temp arr.
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;   // Pasting the elements of temp array into the data array with updated size.
        }
        return super.push(item);  // Going back to the push function where we first say problem due to size. Adding the element through the push method of CustomStack method
    }
}
