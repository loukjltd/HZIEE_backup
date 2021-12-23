#include <iostream>
using namespace std;

int f(char s[]){
    int ascNum;
    int countCapLetter = 0;

    for(ascNum = 0; s[ascNum] != '\0'; ascNum ++){
        if(s[ascNum] >= 'a' && s[ascNum] <= 'z') {
            s[ascNum] -= 32;
            countCapLetter ++;
        }
    }
    return countCapLetter;
}

int main(){
    char getString[128];
    int countCapLetter;
    cin >> getString;
    countCapLetter = f(getString);
    cout << getString << endl;
    cout << countCapLetter << endl;
}