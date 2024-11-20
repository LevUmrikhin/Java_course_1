package ru.isys.trainings.task1;

public class rectangle implements figure {
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
        return "perimeter" + perimeter +
                ", name='" + name + '\'' +
                ", area=" + area + '}';
    }
}

   class square extends rectangle {
   public square(double side, String name) {
       super(name, side, side);     //super calls rectangle class with parameters side, side, name.
       perimeter_and_area();
    }
}