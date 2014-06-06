#include <cstdlib>
#include <cstdio>

int main(void)
{
	int limit = 1000;
	int a, b, c;

	a = 1;
	while (a < limit) {
		b = 1;
		while (b < a) {
			c = limit - (a + b);
			if (a*a + b*b == c*c) {
				printf("%d, %d, %d\n", a, b, c);
				printf("%d\n", a*b*c);
			}

			b++;
		}
		a++;
	}
}
