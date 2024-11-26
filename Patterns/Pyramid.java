package DSA.Patterns;



//    *
//   ***
//  *****
// *******
//  *****
//   ***
//    *


public class Pyramid {

    public static void pyramid(int n) {

        int odd;

        for (int i = 0; i < n; i++) {
            odd = 2 * i + 1;
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < odd; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int  i1= 1; i1 < n; i1++) {
            int oddd = 2 * (n - i1) - 1;

            for (int j1 = 0; j1 < i1; j1++) {
                System.out.print(" ");
            }
            for (int k1 = 0; k1 < oddd; k1++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int n = 4;
        pyramid(n);

    }
}
