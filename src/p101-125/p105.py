from itertools import combinations

special_set_sum = 0

with open("../../resources/p105_sets.txt") as text_file:
    for string_set in text_file:
        num_set = sorted(map(lambda x: int(x), string_set.rstrip().split(",")))

        invalid = False
        discovered_sums = set()
        prev_max_sum = -1
        max_sum = -1

        for n in range(2, len(num_set)+1):
            for p in combinations(num_set, n):
                s = sum(p)
                if s in discovered_sums:
                    invalid = True
                    break
                discovered_sums.add(s)

                if s <= prev_max_sum:
                    invalid = True
                    break

                if s > max_sum:
                    max_sum = s

            if invalid:
                break
            prev_max_sum = max_sum

        if invalid:
            continue

        print(p)
        special_set_sum += sum(num_set)

print(special_set_sum)
