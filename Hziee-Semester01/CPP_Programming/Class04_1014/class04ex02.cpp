#include <iostream>
using namespace std;

class Date{
private:
    int oYear, oMonth, oDay;
    int nYear, nMonth, nDay;

public:
    Date(int original_year, int original_month, int original_day);
    Date(int update_year, int update_month, int update_day, int);
    void show();
    void update_show() const;
};


Date::Date(int original_year, int original_month, int original_day)
{
    oYear = original_year;
    oMonth = original_month;
    oDay = original_day;
}

Date::Date(int update_year, int update_month, int update_day, int)
{
    nYear = update_year;
    nMonth = update_month;
    nDay = update_day;
}

void Date::show(){
    cout << "原日期" << endl;
    cout << oYear << "年" << oMonth << "月" << oDay << "日"  << endl;
}

void Date::update_show() const{
    cout << "修改后日期" << endl;
    cout << nYear << "年" << nMonth << "月" << nDay << "日"  << endl;
}

int main(){
    int original_year, original_month, original_day;
    int new_year, new_month, new_day;

    cin >> original_year >> original_month >> original_day;
    Date date(original_year, original_month, original_day);

    cin >> new_year >> new_month >> new_day;
    Date update_date(new_year, new_month, new_day, 0);

    date.show();
    update_date.update_show();
}
