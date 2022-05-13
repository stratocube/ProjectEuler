from sympy import factorint, isprime
from itertools import combinations
from math import prod, inf

m = 0
Lp = []
Lq = []
r = r0 = s = 0
threshold = 100
effective_primes = []


def init():
    global m, Lp, Lq, r, r0, s, effective_primes
    factor_dict = factorint(m)
    Lq = list(factor_dict.keys())
    Lb = list(factor_dict.values())
    Lp = set()
    Lpow = []
    for i, q in enumerate(Lq):
        for exp in range(Lb[i]+1):
            Lpow.append(q**exp)

    for length in range(1, len(Lpow)+1):
        for power_combo in combinations(Lpow, length):
            tmp = prod(power_combo) + 1
            if isprime(tmp):
                Lp.add(tmp)

    Lpq = list(Lp.intersection(Lq))
    Lp = Lpq + list(Lp.difference(Lpq))
    Lq = Lpq + [x for x in Lq if x not in Lpq]
    r = len(Lp)
    r0 = len(Lpq)
    s = len(Lq)

    effective_primes = []
    for q in Lq:
        effective_primes.append(
            [x for x in range(r) if (Lp[x] - 1) % q == 0])


def best_candidate(p_list_state, quotient):
    best_length = inf
    index = 0

    for i in range(s):
        if ((i < r0 and p_list_state[i] != 1) or i >= r0) and \
                quotient % Lq[i] == 0:
            current_length = len(effective_primes[i])

            if current_length < best_length:
                best_length = current_length
                index = i

    return index


def generate_candidates(p_list_state, index):
    if index != 0:
        if index < r0:
            addition_list = [index] + effective_primes[index]
        else:
            addition_list = effective_primes[index]
    else:
        addition_list = range(r)

    return [x for x in addition_list if p_list_state[x] == 0]


def add_candidates(p_list_state, quotient, p_list_add):
    work_list = []
    for i in range(len(p_list_add)):
        modify_idx = p_list_add[i]
        another_state = p_list_state.copy()
        another_state[modify_idx] = 1

        if quotient % (Lp[modify_idx] - 1) != 0:
            continue
        another_quotient = quotient // (Lp[modify_idx] - 1)

        for x in range(i):
            modify_idx = p_list_add[x]
            another_state[modify_idx] = -1

        for x in range(r):
            if another_state[x] == 0 and \
                    another_quotient % (Lp[x] - 1) != 0:
                another_state[x] = -1

        work_list.append((another_state, another_quotient))
    return work_list


def generate_answers(workflow):
    ans = set()
    for item in workflow:
        p_list_state, quotient = item
        for add_2_back in (0, 1):
            if add_2_back:
                p_list_state[0] = 1

            for j in range(s):
                if ((j < r0 and p_list_state[j] != 1) or
                        j >= r0) and quotient % Lq[j] == 0:
                    break
            else:
                p_selected = [Lp[i] for i in range(len(Lp)) if
                              p_list_state[i] == 1]

                calculation = m
                for p in p_selected:
                    calculation *= p
                    calculation //= p-1
                ans.add(calculation)
    return ans


def inverse_totient(num):
    global m, Lp, threshold
    m = num
    if m % 2 == 1 or m < 0:
        return set()
    if m == 0:
        return 0
    if m == 1:
        return [1, 2]

    init()
    ans = []
    workflow = [([0]*len(Lp), m)]
    workflow[0][0][0] = -1
    iteration = 0
    while iteration < len(workflow):
        if iteration == threshold:
            ans += generate_answers(workflow[:threshold])
            workflow = workflow[threshold:]
            iteration = 0

        (p_list_state, quotient) = workflow[iteration]
        index = best_candidate(p_list_state, quotient)
        p_list_add = generate_candidates(p_list_state, index)
        workflow += add_candidates(p_list_state, quotient, p_list_add)
        iteration += 1

    ans += generate_answers(workflow)
    return ans


if __name__ == "__main__":
    for i in range(2, 26, 2):
        inv_list = inverse_totient(i)
        print(i, len(inv_list), inv_list)

    big_list = inverse_totient(1_024_000)
    print(len(big_list), big_list)

