
package ru.isys.trainings.task1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = scanner.nextInt();
        System.out.println("Enter your text: ");
        String text = scanner.next();


        System.out.println("Integer: " + num);
        System.out.println("Text: " + text);
        scanner.close();
    }

}
