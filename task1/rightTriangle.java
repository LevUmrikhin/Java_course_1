package ru.isys.trainings.task1;

public class rightTriangle extends triangle {
    private static final double angle = Math.PI / 2;

    public rightTriangle(String name, double sideA, double sideB) {
        super(name, sideA, sideB, angle);
        perimeter_and_area();
    }
    public double perimeter() {
        return sideA + sideB + Math.sqrt((sideA * sideA) + (sideB * sideB));
    }
    @Override
    public String toString() {
        return "Rectangle [name=" + name + ", sideA=" + sideA + ", sideB=" + sideB + ", perimeter=" + perimeter + " area=" + area + "]";
    }
}
