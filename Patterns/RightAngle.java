package pythonDSA.Patterns;

class RightAngle {

    public static void triangle(int n) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int n = 4;
        triangle(n);
    }
}
