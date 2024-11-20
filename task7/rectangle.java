package ru.isys.trainings.task7;

import ru.isys.trainings.task7.figure;

public class rectangle implements figure, Comparable<rectangle> {
    protected String name;
    protected double perimeter;
    protected double area;
    protected double side1;
    protected double side2;
    public rectangle(String name, double side1, double side2) { //
        this.name = name;
        this.side1= side1;
        this.side2= side2;
        perimeter_and_area();
    }

    public double getPerimeter() {
        return perimeter;
    }
    public double getArea() {
        return area;
    }
    public void setSide1(double side1) {
        this.side1 = side1;
    }
    public void setSide2(double side2) {
        this.side2 = side2;
    }

    @Override
    public void perimeter_and_area() {
        perimeter = 2 * (side1 + side2);
        area = side1 * side2;
    }
    @Override
    public String toString() {
        return "RightTriangle [perimeter=" + perimeter +
                ", name='" + name + '\'' +
                ", area=" + area + '}';
    }
    @Override
    public int compareTo(rectangle other) {
        int result = 0;
        if (this.area > other.getArea()) {
            result = -1;
        } else if (this.area < other.getArea()) {
            result= 1;
        } else{
            return 0;
        }
        return result;
    }
}

class square extends ru.isys.trainings.task1.rectangle {
    public square(double side, String name) {
        super(name, side, side);     //super calls rectangle class with parameters side, side, name.
        perimeter_and_area();
    }


}