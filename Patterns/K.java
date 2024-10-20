package DSA.Patterns;

// ****

// ***
// **
// *
// *
// **
// ***
// ****

public class K {

    public static void k(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i1 = 1; i1 < n + 1; i1++) {
            for (int j1 = 0; j1 < i1; j1++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 7;
        k(n);

    }
}
