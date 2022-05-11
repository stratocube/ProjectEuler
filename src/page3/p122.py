from collections import defaultdict
from math import inf

limit = 200
additive_chains = defaultdict(list)
min_chain_sizes = [inf] * (limit+1)
explore_list = [{1}]


while len(explore_list) != 0:
    next_set = explore_list.pop()

    for item1 in list(next_set):
        for item2 in list(next_set):
            next_chain = next_set.copy()
            s = item1 + item2

            if s in additive_chains and \
                    len(next_chain) + 1 > len(additive_chains[s][0]):
                continue

            if max(list(next_chain)) < s <= limit and s not in next_chain:
                next_chain.add(s)

                if next_chain not in additive_chains[s]:
                    if len(next_chain) < min_chain_sizes[s]:
                        additive_chains[s] = []
                        min_chain_sizes[s] = len(next_chain)
                    additive_chains[s].append(next_chain)
                    explore_list.append(next_chain)

sum_m = 0
for a in additive_chains:
    m = min(map(lambda x: len(x)-1, additive_chains[a]))
    print(a, m, additive_chains[a])
    sum_m += m

print(sum_m)
