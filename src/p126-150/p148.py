from math import log, floor

MAX_ROW = 10**9
prime = 7


def triangle(n):
    return n*(n+1)//2


def calc_fractal(num, coeff_prod):
    if num == 0:
        return 0

    exp = floor(log(num, prime))
    coeff = num // prime**exp
    remaining = num - coeff * prime**exp

    sum_term = coeff_prod * triangle(coeff) * triangle(prime)**exp
    return sum_term + calc_fractal(remaining, (coeff + 1) * coeff_prod)


print(calc_fractal(MAX_ROW, 1))
