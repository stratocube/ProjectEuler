#include <cstdlib>
#include <cstdio>

int main(void) {
	
	int limit = 100;
	int i = 1;
	long sum = 0, sqrsum = 0;

	sum = limit * (limit+1) / 2;
	sqrsum = limit * (limit+1) * (2*limit+1) / 6;

	printf("%ld\n", sum*sum - sqrsum);
}
