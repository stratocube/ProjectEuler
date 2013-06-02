#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <sstream>

using namespace std;

bool isPalindrome (int num) {
	stringstream ss;
	ss << num;
	string s = ss.str();

	return equal(s.begin(), s.begin() + s.size()/2, s.rbegin());
}

int main(void) {
	const int MAX = 999;
	int largest = 0, a, b, db;
	
	for (a = MAX; a >= 100; a--) {
		if (a % 11 == 0) {
			b = MAX;
			db = 1;
		}
		else {
			b = MAX - MAX%11;
			db = 11;
		}
		for (b = MAX; b >= a; b--) {
			if (a*b <= largest)
				break;

			if (isPalindrome(a*b))
				largest = a*b;
		}
	}

	printf("%d\n", largest);
}

