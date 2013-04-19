#include <stdio.h>

int main(void) {
	int a = 1, b = 1, c, sum = 0;
	while (a < 4000000) {
		if (a % 2 == 0) {
			printf("%d+", a);
			sum += a;
		}

		c = b;
		b = a;
		a = a + c;
	}

	printf("\n%d\n", sum);
}
