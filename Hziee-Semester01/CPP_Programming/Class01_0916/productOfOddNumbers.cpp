#include <iostream>
using namespace std;

int main() {
    int n, m, i;
    __int64_t s;
    while(cin >> n) {
        s = 1;
        for(i = 0; i < n; i++) {
            cin >> m;
            if(m % 2 != 0)
                s = s * m;
        }
        cout << s << endl;
        return 0;
    }
    return 0;
}
