public class Rectangle {
    String id;
    int length;
    int width;

    public void perimeterDefault() {
        id = "default";
        length = 2;
        width = 3;
        System.out.println("id为" + id + "的周长是" + (length + width) * 2);
    }
    public void perimeter(String a, int b, int c) {
        id = a;
        length = b;
        width = c;
        System.out.println("面积是" + length * width);
    }

    public void areaDefault() {
        id = "default2";
        length = 3;
        width = 4;
        System.out.println("面积是" + length * width);
    }
    public void area(String a, int b, int c) {
        id = a;
        length = b;
        width = c;
        System.out.println("面积是" + length * width);
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.perimeterDefault();
        r1.areaDefault();

        Rectangle r2 = new Rectangle();
        r2.perimeter("brandNew", 5, 8);
        r2.area("brandNew2", 5, 8);
    }
 }
