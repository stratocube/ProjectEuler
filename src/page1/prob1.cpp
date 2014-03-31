#include <stdio.h>

int const target = 999;

int sumDivisibleBy(int n) {
	int p = target / n;
	return n * p * (p+1) / 2;
}

int main(void) {

	printf("%d\n", sumDivisibleBy(3) + sumDivisibleBy(5) - sumDivisibleBy(15));
}
