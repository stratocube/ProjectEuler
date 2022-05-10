# Surely there is a less gross way to iterate this.
# Need to find the number of ways two subsets of size k
# such that each variable in one subset is greater than the
# corresponding variable in the other subset.
# Ex A + B + E < C + D + F because A < C, B < D, E < F or seen as a binary array
# All 1's in 110010 are to the left of 1's in 001101

from math import comb


def definitively_unequal_pairs(n, k, lead):
    if n < 0:
        return 0
    if k == 0:
        return 1

    num_pairs = 0
    for i in range(n - 2*k + 1):
        for j in range(max(i+1, lead), n):
            num_pairs += definitively_unequal_pairs(n-2-i, k-1, j-1-i)

    return num_pairs


N = 12
same_sized_subset_pairs = 0
unequal_without_testing = 0

for size in range(2, N//2+1):
    same_sized_subset_pairs += comb(N, size) * comb(N - size, size) // 2
    unequal_without_testing += definitively_unequal_pairs(N, size, 0)

print(same_sized_subset_pairs, unequal_without_testing)
print(same_sized_subset_pairs - unequal_without_testing)
