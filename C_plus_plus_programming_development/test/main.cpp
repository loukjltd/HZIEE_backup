#include<iostream>
#include<cmath>
#include<iomanip>
using namespace std;
int main() {
    int a;
    double b,f,s,t,m;
    s = 0,t = 0,m = 0;
    cin >> a;
    for (int i = 1;i<=a; i++) {
        if (i % 2 == 1){
            b = 1.00/i;
            s = s + b;
        }
        else {
            f = 1.00/i;
            t = t + f;
        }
    }
    m = s - t;
    cout << setprecision(2)<<setiosflags(ios::fixed)<<m<<endl;
    return 0;
}