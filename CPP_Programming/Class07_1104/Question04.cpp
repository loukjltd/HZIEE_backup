#include <iostream>
#include <cstring>

using namespace std;

class Employee{
protected:
    int m_num;
    char m_name[18];
    char m_sex[3];
    int m_wage;
    static int m_count;
    static int m_totalWage;

public:
    Employee(int num, char * name, char * sex, int wage);
    ~Employee();
    void ShowBase();
    static void ShowStatic();
};

int Employee::m_count = 0;
int Employee::m_totalWage = 0;

Employee::Employee(int num, char * name, char * sex, int wage){
    m_num = num;
    strcpy(m_name ,name);
    strcpy(m_sex, sex);
    m_wage = wage;
    m_count++;
    m_totalWage += wage;
}

Employee::~Employee(){
    m_count--;
    m_totalWage -= m_wage;
}

void Employee::ShowBase(){
    cout << "个人基本信息：\n";
    cout << "编号：" << m_num << endl;
    cout << "姓名：" << m_name << endl;
    cout << "性别：" << m_sex << endl;
    cout << "工资：" << m_wage <<endl;
}

void Employee::ShowStatic(){
    cout << "人数：" << m_count << endl;
    cout << "总工资：" << m_totalWage << "元" << endl;
}

int main(){
    
    int n, i, num, wage;
    char name[64], sex[3];

    cin >> n;
    Employee ** employee = new Employee* [n];

    for(i = 0; i < n; i++){
        cin >> num >> name >> sex >> wage;

        employee[i] = new Employee(num, name, sex, wage);
    }

    Employee::ShowStatic();

    for (i = 0; i < n; i++){
        employee[i] -> ShowBase();

        delete employee[i];

        if(i != n - 1){
            cout << endl;
        }
    }

    delete[] employee;

    return 0;
}
