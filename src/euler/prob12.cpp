#include <cstdio>
#include <cmath>

int numDivisors(int num) {
	int divisors = 1, exp;

	//handle 2 and 3 as special case
	exp = 0;
	while (num % 2 == 0) {
		num /= 2;
		exp++;
	}
	divisors *= (exp+1);

	exp = 0;
	while (num % 3 == 0) {
		num /= 3;
		exp++;
	}
	divisors *= (exp+1);

	//the other primes are 6k +/- 1
	int i = 5;
	int root = floor(sqrt(num));
	while (i <= root) {
		exp = 0;
		while (num % i == 0) {
			num /= i;
			exp++;
		}
		divisors *= (exp+1);

		if (i % 6 == 1)
			i += 4;
		else
			i += 2;
		root = floor(sqrt(num));
	}

	//a single largest prime factor
	if (num != 1)
		divisors *= 2;

	return divisors;
}
		
int main(void) 
{
	int n = 0;
	int divisors = 0;
	
	while (divisors <= 500) {
	//while (n <= 10) {
		n++;

		//since t = n*(n+1)/2 and gcd(n,n+1)=1
		if (n % 2 == 0)
			divisors = numDivisors(n/2) * numDivisors(n+1);
		else
			divisors = numDivisors(n) * numDivisors((n+1)/2);
	}

	printf("%d - %ld: %d\n", n, (long)n*(n+1)/2, divisors);
}

