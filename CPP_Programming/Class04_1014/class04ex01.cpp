#include <iostream>
using namespace std;

class People {
public:
    People(char * nm, int a, int h, int w);
    void Sporting(int countTimes);
    void Eating(int countTimes);
    void Show();

private:
    char Name[64];
    int Age;
    int Height;
    int Weight;
};

People :: People(char * nm, int a, int h, int w) {
    strcpy(Name, nm);
    Age = a;
    Height = h;
    Weight = w;
}

void People :: Eating(int countTimes) {
    Weight = Weight + countTimes;
}

void People :: Sporting(int countTimes) {
    Height = Height + countTimes;
}

void People :: Show() {
    cout << "姓名 " << Name << endl;
    cout << "年龄 " << Age << endl;
    cout << "身高 " << Height << endl;
    cout << "体重 " << Weight << endl;
}

int main() {
    char Name[64];
    int Age;
    int Height;
    int Weight;

    int eatingTimes = 0;
    int sportingTimes = 0;

    cin >> Name >> Age >> Height >> Weight;
    People people001(Name, Age, Height, Weight);

    cin >> eatingTimes >> sportingTimes;

    people001.Sporting(sportingTimes);
    people001.Eating(eatingTimes);
    people001.Show();
}