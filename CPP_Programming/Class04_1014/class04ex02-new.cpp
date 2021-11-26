#include <iostream>
using namespace std;

class Date{
private:
    int oldYear, oldMonth, oldDay;
    int newYear, newMonth, newDay;

public:
    Date(int original_year, int original_month, int original_day);
    Date(int update_year, int update_month, int update_day, int);
    void showDate();
    void showUpdateDate();
};

Date :: Date(int original_year, int original_month, int original_day) {
    oldYear = original_year;
    oldMonth = original_month;
    oldDay = original_day;
}
Date :: Date(int update_year, int update_month, int update_day, int) {
    newYear = update_year;
    newMonth = update_month;
    newDay = update_day;
}

void Date :: showDate() {
    cout << "原日期" << endl;
    cout << oldYear << "年" << oldMonth << "月" << oldDay << "日" << endl;
}
void Date :: showUpdateDate() {
    cout << "修改后日期" << endl;
    cout << newYear << "年" << newMonth << "月" << newDay << "日" << endl;
}



int main() {
    int year1, month1, day1;
    int year2, month2, day2;

    cin >> year1 >> month1 >> day1;
    Date oldDate(year1, month1, day1);

    cin >> year2 >> month2 >> day2;
    Date newDate(year2, month2, day2, 0);

    oldDate.showDate();
    newDate.showUpdateDate();
}