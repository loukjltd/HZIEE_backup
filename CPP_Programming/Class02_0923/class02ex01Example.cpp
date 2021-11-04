#include <iostream>
#include <cstring>
#include <cmath>

using namespace std;

double power(double x, int n); // 原函数声明

int main ()  {
    __int64_t value;
    char c[64];

    while (cin >> c){
        if(c[0] == '-'){
            break;
        }
        int len = strlen(c);  // 获取输入的二进制的长度
        value = 0;
        for (int i = len - 1; i >= 0; i--){
            if (c[i] == '1'){
                value += static_cast<__int64_t>(power(2, len - i - 1)); // static_cast<__int64>(参数)将double型数据转换成__int64型数据
            }
        }
        cout  << value << endl;
    }
}

double power (double x, int n){  // 返回给定数字的乘幂，返回类型为double型
    double val = 1.0;

    while (n--){
        val *= x;
    }
    return val;
}

#include <iostream>

using namespace std;

size_t strlen(const char *s){
    size_t len = 0;

    while(*s++){
        len++;
    }

    return len;
}

int main(void){
    char *p = "vvcat";
    cout  << "字符串的长度为：" << strlen(p) << endl;
}

