#include <iostream>
using namespace std;

int main() {
    char s1, s2, s3, min, max, finalMax;
    cin >> s1 >> s2 >> s3;

    if (s1 > s2){
        if (s1 > s3){
            finalMax = s1;
            if (s2 > s3){
                max = s2, min = s3;
            }
            else {
                max = s3; min = s2;
            }
        }else {
            finalMax = s3;
            if (s1 > s2){
                max = s1, min = s2;
            }
            else {
                max = s2; min = s1;
            }
        }
    }else {
        if (s2 > s3){
            finalMax = s2;
            if (s1 > s3){
                max = s1, min = s3;
            }
            else {
                max = s3; min = s1;
            }
        }else {
            finalMax = s3;
            if (s1 > s2){
                max = s1, min = s2;
            }
            else {
                max = s2; min = s1;
            }
        }
    }

    cout << min << max << finalMax << endl;

    return 0;
}


