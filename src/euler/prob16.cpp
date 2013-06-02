#include <cstdio>
#include <sstream>

int main(void)
{
	const int POWER = 1000;
	int carries[POWER] = {0};
	bool carryover = true;
	int lastDigits = 0;
	int n = 1;

	while (carryover) {
		carryover = false;
		for (int i = 0; i < POWER; i++) {
			int temp = 2*n;
			n = temp % 10 + carries[i];

			if (temp >= 10) {
				carries[i] = 1;
				carryover = true;
			}
			else
				carries[i] = 0;
		}
		lastDigits += n;
		n = 0;
	}

	printf("%d\n", lastDigits);
}

