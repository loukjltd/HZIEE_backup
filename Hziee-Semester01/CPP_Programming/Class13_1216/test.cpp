#include <iostream>
using namespace std;

class MyClass {
private:
    int n;					// 数据成员
public:
    MyClass(int k): n(k){

    }			// 构造函数
    int Get() {
        return n;
    }			// 返回n
    int Get() const {
        return n + 1;
    }		// 返回n+1
};
int main() {
    MyClass a(5);				// 定义对象a
    const MyClass b(6);			// 定义对象b
    cout << a.Get() << b.Get() << endl;	// 输出信息

    return 0;                    			// 返回值0, 返回操作系统
}