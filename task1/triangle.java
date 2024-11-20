package ru.isys.trainings.task1;

public abstract class triangle implements figure{
    protected String name;
    protected double perimeter;
    protected double area;
    protected double angle;
    protected double sideA;
    protected double sideB;
    public triangle(String name, double sideA, double sideB, double angle) {
        this.name = name;
        this.angle = angle;
        this.sideA = sideA;
        this.sideB = sideB;
    }
    public double getPerimeter() {
        return perimeter;
    }
    public double getArea() {
        return area;
    }
    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
    public abstract double perimeter();


   //abstract method perimeter
    @Override
    public void perimeter_and_area() {
        this.perimeter= perimeter();
        area = 0.5 * sideA * sideB * Math.sin(angle);
    }
}
