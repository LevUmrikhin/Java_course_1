package ru.isys.trainings.task7;

import ru.isys.trainings.task7.triangle;

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
        return "RightTriangle [name=" + name + ", sideA=" + sideA + ", sideB=" + sideB + ", perimeter=" + perimeter + " area=" + area + "]";
    }
}
