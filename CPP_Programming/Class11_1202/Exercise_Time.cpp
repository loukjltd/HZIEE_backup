#include<iostream>

using namespace std;

class Time{
private:
    int hour;  // 时(hour)
    int minute; // 分(minute)
    int second;  // 秒(second)

public:
    Time(int h, int m, int s){
        hour = h;
        minute = m;
        second = s;
    }

    int getHour(){
        return hour;
    }

    int getMinute(){
        return minute;
    }

    int getSecond(){
        return second;
    }

    friend Time operator + (Time &t1, Time &t2){  // 加法运算符
        int h3, m3, s3;
        h3 = t1.getHour() + t2.getHour();
        m3 = t1.getMinute() + t2.getMinute();
        s3 = t1.getSecond() + t2.getSecond();

        if(s3 > 59){
            s3 = s3 % 60;
            m3 += 1;
        }

        if(m3 > 59){
            m3 = m3 % 60;
            h3 += 1;
        }

        if(h3 == 24){
            h3 = 0;
        }

        Time t3(h3, m3, s3);
        return t3;
    }

    friend istream &operator >>(istream &in, Time &t){ // 重载输入运算符
        char mh1, mh2;

        in >> t.hour >> mh1 >> t.minute >> mh2 >> t.second;

        return in;
    }

    friend ostream &operator<< (ostream &out,Time &t){ // 重载输出运算符
        if(t.hour < 10 && t.minute < 10 && t.second < 10){
            out << "0" << t.hour << ":" << "0" << t.minute << ":" << "0" << t.second;
        } else if(t.hour < 10 && t.minute < 10){
            out << "0" << t.hour << ":" << "0" << t.minute << ":" << t.second;
        } else if(t.hour < 10 && t.second < 10){
            out << "0" << t.hour << ":" << t.minute << ":" << "0" << t.second;
        } else if(t.minute < 10 && t.second < 10){
            out << t.hour << ":" << "0" << t.minute << ":" << "0" << t.second;
        } else if(t.hour < 10){
            out << "0" << t.hour << ":" << t.minute << ":" << t.second;
        } else if(t.minute < 10){
            out << t.hour << ":" << "0" << t.minute << ":" << t.second;
        } else if(t.second < 10){
            out << t.hour << ":" << t.minute << ":" << "0" << t.second;
        } else{
            out << t.hour << ":" << t.minute << ":" << t.second;
        }

        return out;
    }
};

int main(){
    Time time1(0, 0, 0),
            time2(0, 0, 0),
            time3(0, 0, 0);

    cin >> time1 >> time2;

    time3 = time1 + time2;  // 两个时间相加

    cout << time3 << endl;  // 输出两个时间相加的结果

    return 0;
}




