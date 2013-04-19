#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sstream>

using namespace std;

bool isPalindrome (int num) {
	stringstream ss;
	ss << num;
	string s = ss.str();

	int i = 0, l = s.length();
	while (i < l/2) {
		if (s[i] != s[l-i-1])
			return false;
		i++;
	}

	return true;
}

int main(void) {
	const int MAX = 999;
	int a = MAX, b = MAX, max = 0;
	
	for (b = MAX; b > 0; b--) {
		if (isPalindrome(a*b) && (a*b > max))
			max = a*b;

		if (b == a) {
			b = MAX;
			a--;
		}
	}

	printf("%d\n", max);
}

