#include<iostream>
using namespace std;
int main() {
    int a,b;
    __int64_t s,t,m;
    s = 0,t = 0,m = 0;
    cin >> a;
    for (int i = a; 1000 > i > 0; i--) {
        if (i % 2 == 1)
            b = 1/a;
        s = s + b;
    }
    for (int i = a; 1000 > i > 0; i--) {
        if (i % 2 == 0)
            b = 1/a;
        t = t + b;
    }
    m = t - s;
    cout << m;
    return 0;
}