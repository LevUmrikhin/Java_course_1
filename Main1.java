import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        System.out.println("Enter n,k: ");
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.next().split(",");
        int n=Integer.parseInt(a[0]);
        int k=Integer.parseInt(a[1]);
        for (int i = 0; i < n+1; i++) {
            System.out.println(i*k);
        }
        scanner.close();
    }
}