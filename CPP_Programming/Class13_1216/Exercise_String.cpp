#include <iostream>
#include <cstring>
using namespace std;

class str {
public:
    str(const char *s="");
    str(const str &r);
    ~str();
    void show() const;
    void Reverse();
private:
    char *mydata;

};

str::str(const char *s) {
    mydata = new char[strlen(s) + 1];
    strcpy(mydata, s);
    cout << "constructor:" << mydata << endl;
}

str::str(const str &r) {
    mydata = new char[strlen(r.mydata) + 1];
    strcpy(mydata, r.mydata);
    cout << "copyconstructor:" << mydata << endl;
}

str::~str() {
    cout << "destructor" << mydata << endl;
    delete[] mydata;
}

void str::show() const {
    cout << '"' << mydata << '"' << endl;
}

void str::Reverse() {
    int i, len = strlen(mydata);
    char c;
    for(i = 0; i <= len/2; i ++)
    {
        c = mydata[i];
        mydata[i] = mydata[len - i - 1];
        mydata[len - i - 1] = c;
    }
}

int main() {
    str s1, s2("Hello!"), s3 = s2;
    s2.show();
    s3.show();
    s2.Reverse();
    s2.show();
    s3.show();
    return 0;
}
