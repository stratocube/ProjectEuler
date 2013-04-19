#include <stdio.h>
#include <math.h>

int main(void) {
	//int p = 13195;
	long p = 600851475143;

	long i = 2, max = 0;
	long n = sqrt(p);
	while (i < n) {
		if (p % i == 0) {
			p /= i;
			max = i;
			//printf("%d ", i);
		}
		i++;
	}

	printf("%ld\n", max);
}
