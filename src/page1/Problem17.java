#include <cstdio>
#include <string>
#include <vector>

const char* init1[] = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
std::vector<std::string> ones(init1, init1+10);
const char* init2[] = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
std::vector<std::string> teens(init2, init2+10);
const char* init3[] = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
std::vector<std::string> tens(init3, init3+10);

int numLetters (int num) {

	int count = 0;
	int digits[4];
	
	for (int i=0; i<4; i++) {
		digits[i] = num % 10;
		num /= 10;
	}

	if (digits[1] == 1) {
		count = teens[digits[0]].length();
	}
	else {
		count = ones[digits[0]].length();
		count += tens[digits[1]].length();
	}

	if (digits[2] != 0) {
		count += ones[digits[2]].length();
		count += std::string("hundred").length();

		if (digits[0] != 0 || digits[1] != 0) {
			count += std::string("and").length();
		}
	}

	if (digits[3] != 0) {
		count += ones[digits[3]].length();
		count += std::string("thousand").length();
	}

	return count;
}

int main(void) {
	
	int sum = 0;
	for (int i = 1; i <= 1000; i++)
		sum += numLetters(i);

	printf("%d\n", sum);
}
