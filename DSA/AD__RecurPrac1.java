package DSA.DSA;

import java.util.ArrayList;

public class AD__RecurPrac1 {
    public static void main(String[] args) {
        int[] arr = {21, 20, 15, 14, 8, 5, 2};
        System.out.println(binary(arr, 0, arr.length - 1, 8));
        System.out.println("-------------");
        System.out.println(psum(5));
        System.out.println("-------------");
        gis(3);
        System.out.println("-------------");
        coos(3);
        System.out.println("-------------");
        gacos(3);
        System.out.println("-------------");
        System.out.println(factorial(5));
        System.out.println("-------------");
        System.out.println(fibo(6));
        System.out.println("-------------");
        System.out.println(revWOsum(5462));
        System.out.println("-------------");
        revWsum(12345);
        System.out.println(sum);
        System.out.println("-------------");
        System.out.println(palindrome(1221221));
        System.out.println("-------------");
        System.out.println(zeros(1020500,0));
        System.out.println("-------------");
        System.out.println(zeross(10002001));
        System.out.println("-------------");
        int[] arrr={2,3,4,50,6,7,8};
        System.out.println(isSorted(arrr,0));
        System.out.println("-------------");
        System.out.println(isPresent(arrr,50,0));
        System.out.println("-------------");
        System.out.println(linearR(arrr,6,0));
        System.out.println("-------------");
        int[] aar={2,5,4,2,1,2,1,6,2};
        System.out.println(getInd(aar,2,0));
        System.out.println("-------------");
        System.out.println(getIndWAL(aar,2,0));
        System.out.println("-------------");
     }

    //BINARY SEARCH WITH RECURSION:-
    public static int binary(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binary(arr, start, mid - 1, target);
        } else {
            return binary(arr, mid + 1, end, target);
        }
    }

    //PRINTING SUM OF FIRST N NUMBERS USING RECURSION:-
    public static int psum(int num) {
        if (num <= 1) {
            return 1;
        }
        int sum = 0;
        sum = num + psum(num - 1);
        return sum;
    }

    //PRINTING FIRST N NUMBERS:- There are 2 ways of doing this. One is when the function call is getting filled in the stack and the other is when the stack is getting empty.
    //WHEN FUNCTIONS ARE GOING IN STACK(gis):-
    public static void gis(int num) {
        if (num <= 1) {
            System.out.println(1);
            return;
        }
        System.out.println(num);
        gis(num - 1);
    }

    //WHEN FUNCTIONS ARE COMING OUT OF STACK(coos):-
    public static void coos(int num) {
        if (num <= 1) {
            System.out.println(1);
            return;
        }
        coos(num - 1);
        System.out.println(num);
    }

    //WHEN FUNCTION IS GOING AS WELL AS COMING OUT OF STACK(gacos):-
    public static void gacos(int num) {
        if (num < 1) {
            return;
        }
        System.out.println(num);
        gacos(num - 1);
        System.out.println(num);
    }

    //FACTORIAL OF A NUMBER:-
    public static int factorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return factorial(num - 1) * num;
    }

    //FIBONACCHI NUMBER:- A series where the next number is the sum of previous two numbers and the series starts from 1.
    public static int fibo(int num) {
        if (num <= 2) {
            return 1;
        }
        return fibo(num - 1) + fibo(num - 2);
    }

    //REVERSING A NUMBER:- REVERSING WITH SUM VARIABLE(revWsum)
    static int sum = 0;
    public static void revWsum(int num){
        if(num==0){
            return;
        }
        int rem = num%10;
        sum = sum*10 + rem;
        revWsum(num/10);
    }

    //REVERSING A NUMBER:- REVERSE WITHOUT SUM VARIABLE(revWOsum)
    public static int revWOsum(int num){
        int digits=(int)Math.log10(num)+1;
        return helper(num,digits);
    }
    public static int helper(int num, int digits){
        if(num<1){
            return 0;
        }
        return (num%10)*(int)Math.pow(10,digits-1) + helper(num/10,digits-1);
    }

    //PALINDROME:- The number which is the same whether we read it from start or from end.
    //IMPORTANT:- The return keyword is very very important when you want the answer of the innermost recursion call to be taken to the outermost call when we want the answer of the innermost to be given through main.
    public static boolean palindrome(int n){
        int digits = (int) Math.log10(n) + 1 ;
        if(digits<2){
            return true;
        }
        int initial = n / (int)(Math.pow(10,digits-1));
        int last = n % 10;
        if(initial==last){
            n= n - initial * ((int) Math.pow(10,digits-1));
            n = n/10;
            return palindrome(n); // Here the return keyword helps us get the answer of the innermost function all value, which is actually the value of the base condition to come to the top.
            //If this return keyword is not here then the function call before base condition wont be able to transfer the value fof base condition as it wont return but execute the code written after that. And in that case you will get false even if the number is pallindrome and even if answer is write.
        }// the return keyword in pallindrome(n) blocks the code below that if the number is pallindrome. As in such case the value of base condition returns from there itself ans the running of code never hits the last return false statement.
            return false;
        // This return statement will execute if at any stage the upper if condition is not true. In all other cases the value will return from the return palindrome(n).
    }

    //COUNT THE NUMBER OF ZEROS IN A NUMBER:-
    // The answer can be taken in parameter or taken as an external variable.When we take in the parameter then we have to take function call multiple times at every condition. And then we have to modify the value of tat parameter as per requirement of the increment. The external variable has no relation with the consecutive recursive calls.
    // Whereas when we take an external variable, then we just increment that variable at that particular stage. Now this parameter does not have any relation with the consecutive recursive calls but in the case of parameter there is a relation between previous recursive call and next recursive call which is inside for the modification of count.
    //COUNTING THE NUMBER USING THE COUNT(zero) INSIDE THE PARAMETER:-
    public static int zeros(int nu,int zero){ //     5021020
        if(nu<1){
            return zero;
        }
        if(nu%10==0){
            return zeros(nu/10,zero+1);
        }else{
            return zeros(nu/10,zero);
        }
    }
    //COUNTING THE NUMBER USING THE COUNT(zero) OUTSIDE THE FUNCTION AS AN EXTERNAL VARIABLE:-
    static int zero=0;
    public static int zeross(int nu){
        if(nu<1){
            return zero;
        }
        if(nu%10==0){
            zero++;
        }
            return zeross(nu/10);
    }
    // USING THE AND(&&) and OR(||) OPERATOR EFFECTIVELY TO GET THE ANSWER:-
    // CHECKING IF ARRAY IS SORTED BY USING AND(&&) OPERATOR:-
    public static boolean isSorted(int[] arr,int i){
        if(i>arr.length-1){
            return true;
        }
        return arr[i]<arr[i+1] && isSorted(arr,i+1);
    }
    // CHECKING IF AN ELLEMENT IS PRESENT IN AN USING OR(||) OPERATOR:-
    public static boolean isPresent(int[] arr,int target,int i){
        if(i==arr.length-1){
            return false;
        }
        return arr[i]==target || isPresent(arr,target,i+1);
    }
    //LINEAR SEARCH USING RECURSION(linearR):- This helps understand the updation of parameters in the consequetive recursion calls.
    public static int linearR(int[] arr, int target, int index){
        if(index==arr.length-1){
            return -1;
        }
        if(arr[index]==target){
            return index;
        }
        return linearR(arr,target,index+1);
    }

    //TO GET ALL THE INDICES OF THE TARGET ELEMENT PRESENT INSIDE A GIVEN ARRAY:-
    //int[] arr={2,5,4,2,1,2,1,6,2}
    static ArrayList<Integer> ans= new ArrayList<>();
    public static ArrayList<Integer> getInd(int[] arr,int target,int i){
        if(i>arr.length-1){
            return ans;
        }
        if(arr[i]==target){
            ans.add(i);
        }
        return getInd(arr,target,i+1);
    }

    // TO GET ALL THE INDICES OF THE TARGET ELEMENT PRESENT INSIDE A GIVEN ARRAY:- For this kind of logic, we need to create a variable inside the function body and as it is created inside the function body, it will be created everytime the consequetive function is called.
    // We create a main ArrayList<Integer> at the start which will hold the ultimate answer, We also create a ArrayList<Integer> temp which will hold the answer of each consequtive function call and after the function calling hits the base condition, Then it will addAll the elements into the main ans ArrayList.
    // And this is how the ans ArrayList will be filled one by one while returning r coming out of the innermost function call to outermost function call. Each stage the value of that function call is stored in temp while it is returning and then added to the main answer that we want while coming out.
    public static ArrayList<Integer> getIndWAL(int[] arr,int target,int i){
        ArrayList<Integer> ans = new ArrayList<>();
        if(i>arr.length - 1){
            return ans;
        }
        if(arr[i]==target){
            ans.add(i);
        }
        ArrayList<Integer> temp = getIndWAL(arr,target,i + 1);
        ans.addAll(temp);
        return ans;
    }
}
