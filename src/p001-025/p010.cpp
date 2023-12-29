#include <cstdio>
#include <vector>
#include <cmath>

int main(void)
{
	std::vector<int> primes;
	primes.push_back(2);
	primes.push_back(3);
	primes.push_back(5);

	int limit = 2000000;
	int num = 7, i;
	long long sum = 0;
	bool alt = true;

	while (num < limit) {
		//determine if num is prime
		int root = floor(sqrt(num));

		//check against known primes
		//num is not divisible by 2 or 3
		for (i = 2; primes[i] <= root; i++) {
			if (num % primes[i] == 0)
				break;
		}

		if (primes[i] > root) {
			primes.push_back(num);
		}

		if (alt)
			num += 4;
		else
			num += 2;

		alt = !alt;
	}

	for (i = 0; i < primes.size(); i++) {
		sum += primes[i];
	}

	printf("%lld\n", sum);
}
