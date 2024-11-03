import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        System.out.println("Enter x,n");
        Scanner scanner = new Scanner(System.in);
        String[] c = scanner.next().split(",");
        int exponent = 0;
        int n = Integer.parseInt(c[1]);
        int x = Integer.parseInt(c[0]);
        for (int i = 0; i <=n; i++) {
            exponent += powers(n, x)[i]/ factorials(n)[i];
        }
        System.out.println(exponent);
        System.out.println(Math.exp(x));
        scanner.close();

    }

    public static double[] factorials(int a) {
        double[] array = new double[a+1]; //factorials from 0 to n

        for (int i = 0; i < a+1; i++) {
            double i_fact = 1;
            for (int j = 1; j <= i; j++) { //factorial of i
                i_fact *= j;
            }
            array[i] = i_fact; //factorial of i for each i
        }
        return array;
    }

    public static double[] powers(int b, int k) {
        double[] array = new double[b+1]; //powers from 0 to n
        array[0] = 1; //base is k
        for (int i = 1; i < b+1; i++) {

            array[i] = k * array[i-1]; //k*k n times

        }
        return array;

    }
}