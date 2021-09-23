#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

int main() {
    double a, b, c, p, area;
    cin >> a >> b >> c;
    area = 0;
    p = (a + b + c) / 2;
    if (a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0) {
        area = sqrt(p * (p-a) * (p-b) * (p-c));
        cout << "area=" << setprecision(4) << area << endl;
    } else {
        cout << "线段" << setprecision(2)<< setiosflags(ios::fixed)<< a << "," << setprecision(2) << setiosflags(ios::fixed)<< b <<"," << setprecision(2) << setiosflags(ios::fixed)<< c << "不能构成三角形" << endl;
    }
    return 0;
}
