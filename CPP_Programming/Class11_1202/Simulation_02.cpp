#include <iostream>
using namespace std;

int fun(int b[], int n) {
    int r = 1;
    for (int i = 0; i < n; i ++) {
        r = r * b[i];
    }
    return r;
}

int main() {
    int x, a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    x = fun(a, 3);
    cout << x << endl;
    return 0;
}
