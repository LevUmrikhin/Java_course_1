package ru.isys.trainings.task1;



public class Application {
    public static void main(String[] args) {
        rectangle a = new rectangle("a", 30, 25);
        square b = new square(25, "b");
        rightTriangle d = new rightTriangle("d", 10, 15);
        System.out.println(a);
        System.out.println(b);
        System.out.println(d);
    }
}
