#include <iostream>
using namespace std;

int f(int n) {
    int finalNum = 0;
    for (int i = 1; i < n; i ++) {
        if (i % 3 == 2 && i % 5 == 3 && i % 7 == 5) {
            finalNum = i;
        }
    }
    return finalNum;
}

int main() {
    int getNum;
    cin >> getNum;
    cout << f(getNum);
}