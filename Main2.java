import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        System.out.println("Enter array: ");
        Scanner scanner = new Scanner(System.in);
        String[] a = scanner.next().split(",");
        int maxim = 0;
        int minim = Integer.parseInt(a[0]);
        for (int i = 0; i < a.length; i++) {
            if (maxim < Integer.parseInt(a[i])) {
                maxim = Integer.parseInt(a[i]);
            }
            if (minim > Integer.parseInt(a[i])) {
                minim = Integer.parseInt(a[i]);
            }

        }
        System.out.println(maxim);
        System.out.println(minim);
        scanner.close();
    }
}