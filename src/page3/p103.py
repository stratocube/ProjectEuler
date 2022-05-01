from itertools import combinations
from collections import defaultdict
from math import inf


def check_subsets(num_list):
    combo_sums_by_size = defaultdict(set)
    for subset_size in range(1, len(num_list)):
        previous_max = max(combo_sums_by_size[subset_size-1], default=0)
        for combination in combinations(num_list, subset_size):
            combo_sum = sum(combination)
            if combo_sum in combo_sums_by_size[subset_size]:
                return False
            if combo_sum <= previous_max:
                return False

            combo_sums_by_size[subset_size].add(combo_sum)
    return True


def get_valid_sets(set_size, max_num):
    if set_size == 1:
        return [[i] for i in range(1, max_num+1)]

    valid_list = []
    smaller_valid_list = get_valid_sets(set_size-1, max_num)
    for smaller_valid in smaller_valid_list:
        for i in range(max(smaller_valid)+1, max_num+1):
            candidate = smaller_valid + [i]
            if check_subsets(candidate):
                valid_list.append(candidate)

    return valid_list


max_num = 45
min_sum = inf
optimal = []
for candidate in get_valid_sets(7, max_num):
    candidate_sum = sum(candidate)
    if candidate_sum < min_sum:
        min_sum = candidate_sum
        optimal = candidate

print(optimal, min_sum)

