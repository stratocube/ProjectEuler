from sympy import primerange
import timeit

factor_list = {2, 3, 5}


def get_factors():
    for p in primerange(7, 100_000):
        can_be_factor = False
        x = p-1

        two_count = 0
        while x % 2 == 0:
            x //= 2
            two_count += 1

        five_count = 0
        while x % 5 == 0:
            x //= 5
            five_count += 1

        for i in range(two_count + 1):
            for j in range(five_count + 1):
                g = 2**i * 5**j
                if 10**g % p == 1:
                    can_be_factor = True

        if not can_be_factor:
            factor_list.add(p)


t = timeit.Timer(lambda: get_factors())
print(t.timeit(1))
print(sum(factor_list))
