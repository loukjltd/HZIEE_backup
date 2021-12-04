#include <iostream>
#include<cstdio>
using namespace std;

class A
{
private:
    double a;		// 数据成员
public:
    A(int m = 0): a(m) {}	// 构造函数
    int operator int() const// 类型转换函数
    { return (int)a; }
};
int main()
{
    A a = 8.14;		// 定义对象
    cout << a << endl;	// 输出a

    return 0;
}