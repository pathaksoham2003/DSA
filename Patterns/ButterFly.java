// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class ButterFly {
    public static void main(String[] args) {
        int n = 4;
        
        for (int i = 0 ; i<=n ; i++) {
            for (int j = 0 ; j<=n ; j++) {
                if(j == 0 || j == n) {
                    System.out.print("*");
                }else if (i+j==n){
                    System.out.print("*");
                }else if (i==j) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
