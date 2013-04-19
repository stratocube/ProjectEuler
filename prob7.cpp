#include <vector>
#include <cmath>
#include <stdio.h>

int main(void) {

	std::vector<int> primes;
	primes.push_back(2);
	int cnt = 1, num = 3, i;

	while (cnt < 10001) {
		int root = floor(sqrt(num));

		for (i = 1; i < root; i++) {
			if (num % primes[i] == 0)
				break;
		}

		if (i == root) {
			cnt++;
			primes.push_back(num);
		}

		num += 2;
	}

	printf("%d\n", primes.back());
}
