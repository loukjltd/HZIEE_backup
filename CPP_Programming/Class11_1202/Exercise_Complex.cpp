#include <iostream>
#include<cstdio>

using namespace std;

class Complex{
private:
    double real;
    double imag;

public:
    Complex(double r = 0,double i = 0){//构造函数
        real=r;
        imag=i;
    }

    ~Complex(){

    }

    friend Complex operator * (Complex &c1, Complex &c2);
    friend istream& operator >> (istream&, Complex&);
    friend ostream& operator << (ostream&, Complex&);
    friend bool operator == (Complex &c1, Complex &c2);
    friend bool operator != (Complex &c1, Complex &c2);
    void display();
};

Complex operator * (Complex &c1, Complex &c2){
    return Complex(c1.real * c2.real - c1.imag * c2.imag, c1.real * c2.imag + c1.imag * c2.real);
}


istream& operator >> ( istream& in, Complex &c){
    in >> c.real >> c.imag;
    return in;
}
ostream& operator << ( ostream& out, Complex &c){
    out << c.real << "+" << c.imag << "i\n";
    return out;
}

bool operator == (Complex &c1, Complex &c2){
    if(c1.real == c2.real && c1.imag == c2.imag){
        return true;
    } else {
        return false;
    }
}

bool operator != (Complex &c1, Complex &c2){
    if(c1.real != c2.real || c1.imag != c2.imag){
        return true;
    } else {
        return false;
    }
}
void Complex::display( ){
    cout << real << "+" << imag << "i\n" <<endl;
}


int main(){
    Complex c1, c2, c3, c4;

    cin >> c1;
    getchar();

    cin >> c2;
    getchar();

    cin >> c3;
    getchar();

    c4 = c1 * c2;
    c4 = c4 * c3;

    cout << c4;

    return 0;
}
