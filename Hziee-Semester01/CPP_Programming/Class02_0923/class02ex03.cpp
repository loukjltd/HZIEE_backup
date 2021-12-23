#include <iostream>
#include <algorithm>

using namespace std;

int commonDivisor(int num1, int num2) {
    int testCommonDivisor;
    while(num2 != 0){
        testCommonDivisor = num1 % num2;
        num1 = num2;
        num2 = testCommonDivisor;
    }
    return num1;
}

int main(){
    int targetNum1, targetNum2;
    int totalLine[100];
    int i = 0, j;

    while(cin >> targetNum1 >> targetNum2) {
        totalLine[i] = commonDivisor(targetNum1 , targetNum2);
        i++;
    }

    sort(totalLine, totalLine + i);

    for(j = 0; j < i - 1; j++) {
        cout << totalLine[j] << " ";
    }

    cout << totalLine[j] << endl;

    return 0;
}
