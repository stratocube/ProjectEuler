from sympy import primerange, factorint


def spaced_ones(count, spacing):
    num = 0
    for i in range(count):
        num += 10 ** (i*spacing)
    return num


def alternating_ones(odd, spacing):
    num1 = spaced_ones((odd+1)//2, 2*spacing)
    num2 = spaced_ones((odd-1)//2, 2*spacing)
    return num1 - 10**spacing * num2


def mixin_factors(num, add_to_set):
    factorization = factorint(num)
    for factor in factorization:
        mult = factorization[factor]  # appears to always be 1
        add_to_set.add(factor)


factor_set = set()
for exp in range(6):
    num = spaced_ones(2, 2**exp)
    mixin_factors(num, factor_set)
    print("2, 2**exp")

for i in range(0, 6):
    for j in range(0, 2):
        num = alternating_ones(5**j, 2**i)
        mixin_factors(num, factor_set)
        print("alternating 5**j, 2**i")

for i in range(0, 4):
    for j in range(0, 2):
        num = spaced_ones(5, 2**i * 5**j)
        mixin_factors(num, factor_set)
        print("2**i, 5**j")

solution = sorted(list(factor_set))
print(solution[:40])
print(sum(solution[:40]))

for pow in range(4, 5):
    big_ass_number = 0
    for i in range(10**pow):
        big_ass_number += 10**i

    count = 0
    prime_list = []
    for p in primerange(1000000):
        while big_ass_number % p == 0:
            big_ass_number //= p
            count += 1
            prime_list.append(p)
            if count == 40:
                break
        else:
            continue
        break

    print(prime_list)
    print(count, sum(prime_list))
