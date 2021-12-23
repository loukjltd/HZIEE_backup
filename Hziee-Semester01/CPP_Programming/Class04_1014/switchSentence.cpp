#include <iostream>
using namespace std;

int main() {
    int dayInteger;

    cout << "请输入一个0-6的整数：";
    cin >> dayInteger;
    switch (dayInteger) {
        case 0:
            cout << "Sunday";
            break;
        case 1:
            cout << "Monday";
            break;
        case 2:
            cout << "Tuesday";
            break;
        case 3:
            cout << "Wednesday";
            break;
        case 4:
            cout << "Thursday";
            break;
        case 5:
            cout << "Friday";
            break;
        case 6:
            cout << "Saturday";
            break;
        default:
            cout << "Not a weekday...";
    }
    return 0;
}