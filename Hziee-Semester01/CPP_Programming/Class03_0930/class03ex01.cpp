#include <iostream>
using namespace std;

bool wanshu(int n){
    int i, totalNum = 0;
    for (i = 1; i < n; i++){
        if (n % i == 0){
            totalNum += i;
        }
    }

    if (totalNum == n) {
        return true;
    } else {
        return false;
    }
}

int main() {
    int getNum;
    cin >> getNum;

    if(wanshu(getNum)){
        cout << "yes" << endl;
    } else {
        cout << "no" << endl;
    }
}