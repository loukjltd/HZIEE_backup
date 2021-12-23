#include <iostream>
using namespace std;

int main() {
    int num1, num2;
    cout << "请输入两个整数：";
    cin >> num1 >> num2;

    if (num1 != num2) {
        if (num1 > num2) {
            cout << "num1比num2大！";
        } else {
            cout << "num1比num2小！";
        }
    } else {
        cout << "num1与num2相等！";
    }

    return 0;
}