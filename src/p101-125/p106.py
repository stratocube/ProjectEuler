from math import comb
from itertools import combinations


def definitively_unequal_pairs(n, k):
    num_unequal_pairs = 0
    for combo in combinations(list(range(n)), 2*k):
        for sub_combo in combinations(combo, k):
            other_sub_combo = [item for item in combo if item not in sub_combo]
            for i in range(len(sub_combo)):
                if sub_combo[i] > other_sub_combo[i]:
                    break
            else:
                num_unequal_pairs += 1

    return num_unequal_pairs


N = 12
same_sized_subset_pairs = 0
unequal_without_testing = 0

for size in range(2, N//2+1):
    same_sized_subset_pairs += comb(N, size) * comb(N - size, size) // 2
    unequal_without_testing += definitively_unequal_pairs(N, size)

print(same_sized_subset_pairs, unequal_without_testing)
print(same_sized_subset_pairs - unequal_without_testing)
