#include <iostream>
#include <cstring>

using namespace std;

class Incomec{
	private:
		float income;
		static double wage;
		static double taxrate;

	public:
		incomec();
		void setWage(double m);
		static double getTaxrat();
		static double calIncome();
};

Incomec::incomec(){
}

void Incomec::setWage(double salary){
	wage = salary;
}

double Incomec::calIncome(){
	return wage - (wage - 2000) * taxrate;

}

double Incomec::getTaxrat(){
	if (wage <= 2000){
		taxrate = 0;
	} else if (wage < 4000){
		taxrate = 0.05;
	} else if (wage < 7000){
		taxrate = 0.1;
	} else if (wage <= 12000){
		taxrate = 0.15;
	} else {
		taxrate = 0.2;
	}

	return taxrate;
}

double Incomec::taxrate = 0;
double Incomec::wage = 0;


int main(){
	Incomec *incomec = new Incomec();

	double salary;

	for(int i = 0; i < 5; i++){
		cin >> salary;

		incomec -> setWage(salary);
		incomec -> getTaxrat();

		cout << incomec -> calIncome() << endl;
	}

	delete incomec;

	return 0;
}
