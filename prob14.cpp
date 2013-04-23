#include <cstdio>
#include <vector>

long collatz(long n) {
	static std::vector<int> discovered(1000000, 0);
	int links;

	if (n <= 1)
		return 1;

	//lookup table
	if (n < discovered.size() && discovered.at(n) != 0)
		return discovered.at(n);

	if (n % 2 == 0)
		links = 1 + collatz(n/2);
	else
		links = 1 + collatz(3*n+1);

	if (n < discovered.size())
		discovered.at(n) = links;

	return links;
}

int main(void)
{
	int max = 0, longest = 0;
	for (int i = 1; i < 1000000; i++) {
		int terms = collatz(i);
		if (terms > max) {
			max = terms;
			longest = i;
		}
	}

	printf("%d: %d\n", longest, max);
}

