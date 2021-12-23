#include <iostream>

using namespace std;

__int64_t customFunction(int x, int y) {
    int defaultX, defaultY = 1;
    __int64_t getResult = 1;
    for (defaultX = x; defaultY <= y; defaultX--) {
        getResult = getResult * defaultX / defaultY;
        defaultY++;
    }
    return getResult;
}

int main() {
    int targetX, targetY;
    while(cin >> targetX >> targetY) {
        if(targetX <= 50 && targetY <= 50 && targetX > 1 && targetY > 1) {
            cout << customFunction(targetX, targetY) << endl;
        }else{
            break;
        }
    }
}