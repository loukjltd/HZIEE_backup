#include <iostream>
#include <bitset>

using namespace std;

int main() {
    string binaryNum;
    string testNum = "";
    string finalTarget[64];

    for (int i = 0; i < 64; i = i + 1) {
        cin >> binaryNum;
        if (binaryNum != "-1") {
            bitset<64> num (binaryNum);
            testNum = to_string((num.to_ulong()));
            finalTarget[i] = testNum;
        } else if (binaryNum == "-1") {
            break;
        }
    }

    for (int i = 0; i < 64; ++i) {
        if (finalTarget[i] != ""){
            cout << finalTarget[i] << endl;
        }

    }
    return 0;
}