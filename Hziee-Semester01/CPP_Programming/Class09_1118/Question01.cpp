#include<iostream>
#include<cstring>
using namespace std;

class Employee {
public:
    Employee(int new_num, char* new_name, double new_basicSal, double new_prize);
    void Show();
    double OutputWage1();
    void ShowSalary();
private:
    int num;
    char name[18];
    double basicSal;
    double prize;
};

Employee::Employee(int new_num, char* new_name, double new_basicSal, double new_prize){
    num = new_num;
    strcpy(name, new_name);
    basicSal = new_basicSal;
    prize = new_prize;
}

void Employee::Show() {
    cout << "编号:" << num << endl;
    cout << "姓名:" << name << endl;
    cout << "基本工资:" << basicSal << "元" << endl;
    cout << "奖金:" << prize << "元" << endl;
}

double Employee::OutputWage1(){
    double salary;
    salary = basicSal + prize;
    return salary;
}

void Employee::ShowSalary(){
    cout << "实发工资:" << OutputWage1() << "元" << endl;
}

//销售员类
class Saleman :virtual public Employee {
public:
    Saleman(int a, char* b, double d, double e, double f, double g);
    void Output2();
    void output2();
    double OutputWage2();
    void ShowSalary();
private:
    double daductRatr;
    double personAmount;
};

Saleman::Saleman(int new_num, char* new_name, double new_basicSal, double new_prize, double new_daductRatr, double new_personAmount) :Employee(new_num, new_name, new_basicSal, new_prize){
    daductRatr = new_daductRatr;
    personAmount = new_personAmount;
}

void Saleman::Output2() {
    Show();
    cout << "销售员提成比例:" << daductRatr << endl;
    cout << "个人销售额:" << personAmount << "元" << endl;
}

void Saleman::output2() {
    cout << "销售员提成比例:" << daductRatr << endl;
    cout << "个人销售额:" << personAmount << "元" << endl;
}

double Saleman::OutputWage2() {
    double salary;
    salary = Employee::OutputWage1() + personAmount * daductRatr;
    return salary;
}

void Saleman::ShowSalary(){
    cout << "实发工资:" << OutputWage2() << "元" << endl;
}

class Manager :virtual public Employee {
public:
    Manager(int new_num, char* new_name, double new_basicSal, double new_prize, double new_totalDeductRate, double new_totalAmount);
    void Output3();
    void output3();
    double OutputWage3();
    void ShowSalary();
private:
    double totalDeductRate;
    double totalAmount;
};

Manager::Manager(int new_num, char* new_name, double new_basicSal, double new_prize, double new_totalDeductRate, double new_totalAmount) :Employee(new_num, new_name, new_basicSal, new_prize){
    totalDeductRate = new_totalDeductRate;
    totalAmount = new_totalAmount;
}

void Manager::Output3() {
    Show();
    cout << "经理提成比例:" << totalDeductRate << endl;
    cout << "总销售额:" << totalAmount << "元" << endl;
}

void Manager::output3() {
    cout << "经理提成比例:" << totalDeductRate << endl;
    cout << "总销售额:" << totalAmount << "元" << endl;
}

double Manager::OutputWage3() {
    double salary;
    salary = Employee::OutputWage1() + totalAmount * totalDeductRate;
    return salary;
}

void Manager::ShowSalary(){
    cout << "实发工资:" << OutputWage3() << "元" << endl;
}

class SaleManager :public Saleman, public Manager {
public:
    SaleManager(int new_num, char* new_name, int new_basicSal, int new_prize, double f, double g, double h, double i);
    void Output4();
    double OutputWage4();
    void ShowSalary();
};

SaleManager::SaleManager(int new_num, char* new_name, int new_basicSal, int new_prize, double new_daductRatr, double new_personAmount, double new_totalDeductRate, double new_totalAmount) :
        Saleman(new_num, new_name, new_basicSal, new_prize, new_daductRatr, new_personAmount), Manager(new_num, new_name, new_basicSal, new_prize, new_totalDeductRate, new_totalAmount), Employee(new_num, new_name, new_basicSal, new_prize) {
}

void SaleManager::Output4() {
    Employee::Show();
    Saleman::output2();
    Manager::output3();
}

double SaleManager::OutputWage4() {
    double salary;
    salary = Saleman::OutputWage2() + Manager::OutputWage3() - Employee::OutputWage1();
    return salary;
}

void SaleManager::ShowSalary(){
    cout << "实发工资:" << OutputWage4() << "元" << endl;
}

int main() {
    Employee e(106,  "李明", 1680, 1080);
    cout << "员工信息:" << endl;
    e.Show();
    e.ShowSalary();
    cout << "" << endl;

    Saleman s(108, "李杰明", 2680, 1680, 0.15, 23000);
    cout << "销售员信息:" << endl;
    s.Output2();
    s.ShowSalary();
    cout << "" << endl;

    Manager m(116, "吴倩", 3680, 2680, 0.1, 83000);
    cout << "经理信息:" << endl;
    m.Output3();
    m.ShowSalary();
    cout << "" << endl;

    SaleManager sm(118, "吴杰", 3680, 2680, 0.15, 28000, 0.1, 88000);
    cout << "销售经理信息:" << endl;
    sm.Output4();
    sm.ShowSalary();
    return 0;
}