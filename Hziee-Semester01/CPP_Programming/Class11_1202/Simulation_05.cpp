#include <iostream>
using namespace std;

int fun(const int *m, int n) {
    int k = 0;
    for (int i = 0; i < n; i ++) {
        if (*(m + i) > *(m + k)) {
            k = i;
        }
    }
    return k;
}