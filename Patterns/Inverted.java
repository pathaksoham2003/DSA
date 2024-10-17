package DSA.Patterns;

public class Inverted {

    public static void invert(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n-i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Inverted.invert(n);
    }
}
