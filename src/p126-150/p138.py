from math import isqrt
import timeit


def do_calc():
    k_prev = 0
    k = 2

    L_sum = 0
    count = 0
    while count < 12:
        L = isqrt(80*k**2 - 16*k + 1)
        k_next = 2*L + k_prev
        k_prev = k
        k = k_next

        count += 1
        L_sum += L
        # print(count, L, k)

        L = isqrt(80*k**2 + 16*k + 1)
        k_next = 2*L + k_prev
        k_prev = k
        k = k_next

        count += 1
        L_sum += L
        # print(count, L, k)

    print(L_sum)


t = timeit.Timer(lambda: do_calc())
print(t.timeit(1))
