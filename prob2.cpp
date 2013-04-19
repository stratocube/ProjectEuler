#include <stdio.h>

const int limit = 4000000;

int main(void) {
	int sum = 0, a = 0, b = 2, t;
	while (b < limit) {
		sum += b;

		t = b;
		b = 4*b + a;
		a = t;
	}

	printf("%d\n", sum);
}
