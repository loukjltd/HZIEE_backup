#include <iostream>
using namespace std;

class Base {
public:
    Base(int x = 0):valB(x) {
        cout << valB;
    }
    ~Base() {
        cout << valB;
    }
private:
    int valB;
};

class Derived: public Base {
public:
    Derived(int x = 0, int y = 0): Base(x), valD(y) {
        cout << valD;
    }
    ~Derived() {
        cout << valD;
    }
private:
    int valD;
};

int main() {
    Derived obj1(2, 3);
    return 0;
}