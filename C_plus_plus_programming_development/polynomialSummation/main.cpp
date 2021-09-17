#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;

int main() {
    int o, n, l, t;
    cin >> l;
    t = 1;
    for(n = 1;n <= l;n ++){
        t *= n;
    }
    o = t;
    for (n = 2;n <= l;n ++){
        if (n % 2 == 1){
            o += t / n;
        }else {
            o -= t/n;
        }
    }
    cout << setprecision(2)<< setiosflags(ios::fixed) << (double)o/t;
}
