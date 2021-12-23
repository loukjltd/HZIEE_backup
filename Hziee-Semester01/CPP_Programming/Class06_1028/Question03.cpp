#include <iostream>
#include <iomanip>
using namespace std;

int absolute_value(int num1) {
    if(num1 >= 0) {
        return num1;
    } else {
        return -num1;
    }
}

class Point {
private:
    int x, y;
public:
    Point();
    Point(int x = 0, int y = 0);
    Point(Point & p);
    ~Point();
    int getX(){return x;}
    int getY(){return y;}
};

Point::Point(){
}
Point::Point(int point_x, int point_y) {
    x = point_x;
    y = point_y;
}
Point::Point(Point & p) {
    x = p.x; y = p.y;
}
Point::~Point(){
}

class Ellipse{
private:
    Point a, b;
public:
    Ellipse(int xx1, int yy1, int xx2, int yy2);
    Ellipse(Point & p1, Point & p2);
    ~Ellipse();

    double area();
    int getX1(){ return a.getX(); }
    int getY1(){ return a.getY(); }
    int getX2(){ return b.getX(); }
    int getY2(){ return b.getY(); }
    void show();
};

Ellipse::Ellipse(int xx1, int yy1, int xx2, int yy2):a(xx1, yy1), b(xx2, yy2) {

}

Ellipse::Ellipse(Point &p1, Point & p2):a(p1), b(p2) {
}

Ellipse::~Ellipse(){
}

double Ellipse::area(){
    return (double)(3.1415 * absolute_value(b.getX() - a.getX()) * absolute_value(b.getY() - a.getY()) / 4);
}

void Ellipse::show() {
    cout << a.getX() << " " << a.getY() << " " << b.getX() << " " << b.getY() << endl;
}

int main(void){
    int x1, y1, x2, y2;
    int x3, y3;
    int x4, y4;

    cin >> x1 >> y1 >> x2 >> y2;
    cin >> x3 >> y3;
    cin >> x4 >> y4;

    Ellipse e1(x1, y1, x2, y2);
    Point p1(x3, y3);
    Point p2(x4, y4);
    Ellipse e2(p1, p2);

    e1.show();
    e2.show();

    cout << fixed << setprecision(2) << e1.area() << endl;
    cout << fixed << setprecision(2) << e2.area() << endl;
}
