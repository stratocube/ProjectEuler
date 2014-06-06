#include <cstdio>
#include <cmath>

//long p = 13195;
long p = 600851475143;

void divideOut(int n) {
	while (p % n == 0) {
		p /= n;
	}
}

int main(void) {

	divideOut(2);
	divideOut(3);

	long i = 5;
	long limit = sqrt(p);

	while (i < limit) {
		divideOut(i);
		divideOut(i+2);

		limit = sqrt(p);
		i += 6;
	}

	printf("%ld\n", p);
}
