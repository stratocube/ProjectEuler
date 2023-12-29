#include <cstdio>
#include <vector>

long collatz(long long n) {
	static std::vector<long> discovered(1000000);
	long links;

	if (n < 1) {
		printf("error\n");
		return 0;
	}
	if (n == 1)
		return 1;

	//lookup table
	if (n < discovered.size() && discovered.at(n) != 0)
		return discovered.at(n);

	if (n % 2 == 0)
		links = collatz(n/2) + 1;
	else
		links = collatz(3*n+1) + 1;

	if (n < discovered.size())
		discovered.at(n) = links;

	return links;
}

int main(void)
{
	long max = 0;
	long long longest = 0;
	for (long long i = 1; i < 1000000; i++) {
		long terms = collatz(i);
		if (terms > max) {
			max = terms;
			longest = i;
		}
	}

	printf("%lld: %ld\n", longest, max);
	
}

