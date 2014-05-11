#include <stdio.h>
#define MIN(A, B) ((A) < (B) ? (A) : (B))

int main(int argc, char *argv[]) {
	if (argc != 3) {
		printf("Invalid arguments\n");
		return 1;
	}

	int number = atoi(argv[1]);
	int highest = atoi(argv[2]);

	if (number <= 0 || highest <= 0) {
		printf("Invalid arguments\n");
		return 2;
	}
	printf("%i\n", numSums(number, highest));
}

//number > 0 and highest > 0
int numSums(int number, int highest) {
	if (number == 1 || highest == 1) {
		return 1;
	}

	int sum = 1;
	int first, multiple, remainder;
	for (first = 2; first <= highest; first++) {
		if (number % first == 0) {
			sum++;
		}
		for (multiple = 1; multiple <= (number-1)/first; multiple++) {
			remainder = number - multiple*first;
			sum += numSums(remainder, MIN(first-1, remainder));
		}
	}

	return sum;
}
