package DSA.DSA;

import java.util.*;

public class AI__StacksQueues {
    public static void stack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(50);
        stack.push(40);
        stack.push(30);
        stack.push(20);
        stack.push(10);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    public static void queue(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
    public static void deque(){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(30);
        deque.addFirst(20);
        deque.addLast(40);

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.remove());
    }
    public static void main(String[] args) {
        stack();
        System.out.println("-------------------------------------- ");
        queue();
        System.out.println("-------------------------------------- ");
        deque();
        System.out.println("-------------------------------------- ");
    }
}
