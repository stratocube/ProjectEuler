#include <stdlib.h>
#include <stdio.h>

int main(void) {
	
	int i = 1;
	long sum = 0, sqrsum = 0;
	for (i = 1; i <= 100; i++) {
		sum += i;
		sqrsum += i*i;
	}

	printf("%ld\n", sum*sum - sqrsum);
}
