#include <iostream>
using namespace std;

int main() {
    int getNum, reversedNum;
    cout << "请输入一个整数：";
    cin >> getNum;

    cout << "我们把这个数倒过来就是：";
    do {
        reversedNum = getNum % 10;
        cout << reversedNum;
        getNum = getNum / 10;
    } while (getNum != 0);

    return 0;
}