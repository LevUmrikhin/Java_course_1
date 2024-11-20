

public class Main8 {
    public static void main(String[] args) {
    }
    public interface figure {    //interface for sorting
        void perimeter_and_aria();
    }
    abstract class figureImp implements figure {              //should be abstract
        protected String name;
        protected double perimeter;
        protected double area;
        public figureImp(String name) { //
            this.name = name;
        }
    }
    public class circle extends figureImp {

        private double radius;
        public circle(String name, double radius) {
            super(name);
            this.radius = radius;
        }

        @Override
        public void perimeter_and_aria() {
            perimeter= 2*Math.PI * radius;
            area= Math.PI * radius * radius;

        }
        public double getPerimeter() {
            return perimeter;
        }
        public double getArea() {
            return area;
        }

    }

    public class square extends figureImp  {
        private double side;

        public square(String name, double side){
            super(name);
            this.side = side;

        }

        @Override
        public void perimeter_and_aria() {
            perimeter = 4 * side;
            area= side * area;
        }

        public double getPerimeter() {
            return perimeter;
        }
        public double getArea() {
            return area;
        }

    }

    public class triangle extends figureImp  {

        private double side1;
        private double side2;
        private double side3;
        private double s;

        public triangle(String name, double side1, double side2, double side3, double s) {
            super(name);
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            this.s = s;
        }

        @Override
        public void perimeter_and_aria() {
            perimeter = side1+side2+side3;
            s= perimeter/2;
            area= Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));

        }
        public double getPerimeter() {
            return perimeter;
        }
        public double getArea() {
            return area;
        }
    }
}