#include <iostream>
using namespace std;

int main() {
    cout << endl;
    int m, n, total;
    cin >> m;
    cin >> n;
    total = 0;
    for (int i = m; i <= n; ++i) {
        total = total + i;
    }
    cout << total << endl;

    return 0;
}
