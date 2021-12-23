#include <iostream>
#include <iomanip>
using namespace std;

int absolute_value(int num1) {
    if (num1 >= 0) {
        return num1;
    } else {
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
    int getX1();
    int getY1();
    int getX2();
    int getY2();
    void area();
};

Ellipse::Ellipse(void) {
}

Ellipse::Ellipse(int new_x1, int new_y1, int new_x2, int new_y2) {
    x1 = new_x1;
    y1 = new_y1;
    x2 = new_x2;
    y2 = new_y2;
}

int Ellipse::getX1() {
    return x1;
}
int Ellipse::getX2() {
    return x2;
}
int Ellipse::getY1() {
    return y1;
}
int Ellipse::getY2() {
    return y2;
}

void Ellipse::area(){
    ellipse_area = (double)(3.1415 * absolute_value(x2 - x1) * absolute_value(y2 - y1) / 4 );
    cout << fixed << setprecision(2) << ellipse_area << endl;
}

int main(void){
    int x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;
    Ellipse ellipse(x1, y1, x2, y2);
    cout << ellipse.getX1() << " " << ellipse.getY1() << " " << ellipse.getX2() << " " << ellipse.getY2() << endl;
    ellipse.area();
}