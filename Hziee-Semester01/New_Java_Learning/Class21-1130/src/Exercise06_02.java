class Point{
    int x, y;
    Point(int x, int y){this.x = x; this.y = y;}
    public double ToOrigin(){return Math.sqrt(x * x + y * y);}
}
class myPoint extends Point{
    char name;
    myPoint(int x, int y, char name){
        super(x, y);
        this.name = name;
    }
    public String toString(){
        return name +"(" + x + ", " + y + ")";
    }
}

public class Exercise06_02 {
    public static void main(String[] args) {
        myPoint A = new myPoint(3,4,'Q');
        System.out.printf("%s到原点的距离为%.2f", A.toString(), A.ToOrigin());
    }
}
