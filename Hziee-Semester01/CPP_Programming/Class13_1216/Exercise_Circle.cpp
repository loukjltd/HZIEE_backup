#include <iostream>
using namespace std;

class Point {
private:
    int x, y;
public:
    Point(int xx, int yy) : x(xx), y(yy) {
    }
    Point(const Point & p) : x(p.x), y(p.y) {
    }
    int getx() const {
        return x;
    }
    int gety() const {
        return y;
    }
};

class Circle {
private:
    Point c;
    double r;
    double const pi;
public:
    Circle(int xx, int yy, int rr) : c(xx, yy), r(rr), pi(3.1415) {
    }
    Circle(const Circle & cl) : c(cl.c), r(cl.r), pi(3.1415) {
    }
    void change() {
        r *= 2;
    }
    void show() const{
        cout << "(" << c.getx() << "," << c.gety() << ")" << r << endl;
    }
    double area() const{
        return r * r * pi;
    }
};

int main(){
    int x,y;
    double r;
    cin>>x>>y>>r;
    const Circle c1(x,y,r);
    Circle c2(c1);
    c1.show();
    cout << c1.area() << endl;
    c2.change();
    c2.show();
    cout << c2.area() << endl;
    return 0;
}