#include <iostream>
using namespace std;

int CountChar(char * p,char ch){
    int n = 0;
    int i = 0;

    while (* (p + i) != '\0') {
        if(* (p + i) == ch) {
            n ++;
        }
        i ++;
    }
    return n;
}

int main() {
    char getString[20], targetString;
    int n;

    gets(getString);
    targetString = getchar();
    n = CountChar(getString, targetString);
    cout << n << endl;
}