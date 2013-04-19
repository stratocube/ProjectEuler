#include <stdio.h>
#include <stdlib.h>

int main(void) {
	int num = 20, prod = 1;
	int i, j;
	int factors[num-1];

	for (i=2; i<=num; i++) {
		factors[i-2] = i;
	}
	for (i=0; i<num-1; i++) {
		for (j=i+1; j<num-1; j++) {
			if (factors[j] % factors[i] == 0) {
				factors[j] /= factors[i];
			}
		}
	}

	for (i=0; i<num-1; i++) {
		prod *= factors[i];
	}

	printf("%d\n", prod);
}
