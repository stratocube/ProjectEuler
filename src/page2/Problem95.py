from sympy import divisors

longest_chain = []

for i in range(1, 15000):
    chain = []
    next_num = i
    while next_num not in chain:
        chain.append(next_num)
        d = divisors(next_num)[:-1]
        next_num = sum(d)
        if next_num == 0 or next_num > 1000000:
            break
    else:
        #print(chain)
        repeat_idx = chain.index(next_num)
        truncated_chain = chain[repeat_idx:]

        if len(truncated_chain) > len(longest_chain):
            longest_chain = truncated_chain
            print(longest_chain)
