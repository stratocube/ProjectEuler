#include <vector>
#include <cmath>
#include <stdio.h>

int main(void) {

	std::vector<int> primes;
	primes.push_back(2);
	primes.push_back(3);
	primes.push_back(5);

	int cnt = 3, i;
	long num = 7;
	bool alt = true;

	while (cnt < 10001) {
		int root = floor(sqrt(num));

		i = 2;
		while (primes[i] <= root) {
			if (num % primes[i] == 0)
				break;
			i++;
		}

		if (primes[i] > root) {
			cnt++;
			primes.push_back(num);
		}

		if (alt)
			num += 4;
		else
			num += 2;

		alt = !alt;
	}

	printf("%d\n", primes.back());
}
