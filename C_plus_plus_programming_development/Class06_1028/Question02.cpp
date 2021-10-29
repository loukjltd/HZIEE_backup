#include <iostream>
#include <iomanip>
using namespace std;

int absolute_value(int num1) {
    if(num1 >= 0) {
        return num1;
    }else{
        return -num1;
    }
}

class Ellipse {
private:
    int x1, y1, x2, y2;
    double ellipse_area;

public:
    Ellipse();
    Ellipse(int new_x1, int new_y1, int new_x2, int new_y2);
    Ellipse(const Ellipse & e);
    ~Ellipse();
    int getX1();
    int getY1();
    int getX2();
    int getY2();
    void area();
    void show();
    void fun(int y);
};

Ellipse::Ellipse(void) {

}

Ellipse::Ellipse(int new_x1, int new_y1, int new_x2, int new_y2) {
    x1 = new_x1;
    y1 = new_y1;
    x2 = new_x2;
    y2 = new_y2;
}

Ellipse::Ellipse(const Ellipse & e) {
    x1 = e.x1;
    x2 = e.x2;
    y1 = e.y1;
    y2 = e.y2;
}

Ellipse::~Ellipse() {
    cout<<"xigou "<<x1<<" "<<y1<<endl;
}

int Ellipse::getX1(){
    return x1;
}
int Ellipse::getX2(){
    return x2;
}
int Ellipse::getY1(){
    return y1;
}
int Ellipse::getY2(){
    return y2;
}

void Ellipse::area() {
    ellipse_area = (double)( 3.1415 * absolute_value(x2 - x1) * absolute_value(y2 - y1) / 4 );
    cout << fixed << setprecision(2) << ellipse_area << endl;
}

void Ellipse::show() {
    cout << x1 << " " << y1 << " " << x2 << " " << y2 << endl;
}

void Ellipse::fun(int y) {
    y1 += y;
    y2 -= y;
}

int main(void) {
    int x1, y1, x2, y2, y;
    cin >> x1 >> y1 >> x2 >> y2;
    cin >> y;

    Ellipse ellipse(x1, y1, x2, y2);
    Ellipse ellipse2 = ellipse;

    ellipse.show();
    ellipse2.show();
    ellipse.area();
    ellipse2.area();
    ellipse2.fun(y);
    ellipse2.area();
}
