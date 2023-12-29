#include <cstdio>

int main(void)
{
	const int SIZE = 20;
	long long paths[SIZE+1][SIZE+1];

	for (int i = 0; i <= SIZE; i++) {
		paths[i][0] = 1;
	}

	for (int i = 1; i <= SIZE; i++) {
		for (int j = 1; j < i; j++)
			paths[i][j] = paths[i-1][j] + paths[i][j-1];

		paths[i][i] = 2*paths[i][i-1];
	}

	printf("%lld\n", paths[SIZE][SIZE]);
}
