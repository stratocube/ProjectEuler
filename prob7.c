#include <stdio.h>
#include <stdlib.h>

int main(void) {

	int size = 70000;
	int seive[size];
	int i, j, cnt = 0;

	for (i=0; i<size; i++) {
		seive[i] = 2*i+1;
	}
	seive[0] = 2;

	i = 1, cnt = 1;
	while (cnt < 10001) {
		if (i == size) {
			printf("Need more memory!\n");
			exit(-1);
		}

		if (seive[i] == 1) {
			i++;
			continue;
		}
		cnt++;

		for (j=i+1; j<size; j++) {
			while (seive[j] != 1 && seive[j] % seive[i] == 0) {
				seive[j] /= seive[i];
			}
		}
		i++;
	}

	printf("%d\n", seive[i-1]);
}
