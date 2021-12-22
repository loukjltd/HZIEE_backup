#include <iostream>
using namespace std;
int main() {
    int a[5] = {1, 2, 3, 4, 0};
    int * x;
    x = a;
    while (* x) {
       cout << x << "|";
       cout << * (x ++) << endl;
    }
    return 0;
}