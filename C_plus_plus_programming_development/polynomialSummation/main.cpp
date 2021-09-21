#include<iostream>
#include<iomanip>
using namespace std;
int main() {
    int inputNum;
    double oddTotal, evenTotal, finalTotal, oddMidNum, evenMidNum;
    oddTotal = 0, evenTotal = 0;

    cin >> inputNum;

    for (int i = 1; i <= inputNum; i++) {
        if (i % 2 == 1) {
            oddMidNum = 1.00 / i;
            oddTotal = oddTotal + oddMidNum;
        } else if (i % 2 == 0) {
            evenMidNum = 1.00 / i;
            evenTotal = evenTotal + evenMidNum;
        }
    }

    finalTotal = oddTotal - evenTotal;
    cout << setprecision(2)<< setiosflags(ios::fixed) << finalTotal << endl;
    return 0;
}
