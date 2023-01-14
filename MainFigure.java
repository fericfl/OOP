public class MainFigure {
    public static void main(String[] args) {
        Figure c1 = new Circle("red", 10);
        Figure s1 = new Square("blue", 5);
        Figure t1 = new Triangle("green", 1, 2, 3);
        Figure t2 = new Triangle("yellow", 3, 2, 1);

        System.out.println(((Circle)c1).getPerimeter());
        ((Circle)c1).setRadius(12);
        System.out.println(((Circle)c1).getPerimeter());
        System.out.println(((Square)s1).getPerimeter());
        System.out.println(((Triangle)t1).getPerimeter());
        System.out.println(((Circle)c1).equals(t1)); 
        System.out.println(((Triangle)t1).equals(t2));
    }
}

class Circle extends Figure{
    public double radius;
    public Circle(String color, double radius) {
        super(color);
        setRadius(radius);
    }

    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean equals(Figure o) {
        if(o instanceof Circle && o.getPerimeter() == getPerimeter())
            return true; 
        return false;
    }
}

class Square extends Figure{
    public double side;
    public Square(String color, double side) {
        super(color);
        setSide(side);
    }

    public double getPerimeter() {
        return 4 * side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public boolean equals(Figure o) {
        if(o instanceof Square && o.getPerimeter() == getPerimeter())
            return true;
        return false;
    }
}

class Triangle extends Figure{
    public double side1;
    public double side2;
    public double side3;
    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        setSide(side1,side2,side3);
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public void setSide(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public boolean equals(Figure o) {
        if(o instanceof Triangle && o.getPerimeter() == getPerimeter())
            return true;
        return false;
    }
}

class Figure {
    protected String color;
    protected int count = 1;
    protected double perimeter = 0;

    public Figure(String color) {
        setColor(color);
        count++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPerimeter() {
        return perimeter;
    }
}

final class Observer {
    public Figure[] entries;
    public int count = 0;
    public int size;

    public Observer(int size) {
        entries = new Figure[size];
    }

    public boolean addFigure(Figure f) {
        if(! (f instanceof Figure))
            return false;
        if(count >= size) {
            System.out.println("Observer is full");
            return false;
        }
            
        entries[count] = new Figure(f.color);
        return true;
    }

    public String Modified() {
        String aux = "";
        for(int i = 0; i < count; i++)
            aux += entries[i].getClass() + " --- " + entries[i].getColor() + " --- " + entries[i].getPerimeter() + "\n";
        return aux;
    }
}