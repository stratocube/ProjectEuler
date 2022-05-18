from math import isqrt, gcd


numerator = 1
count = 0
while count < 15:
    sqr = 5 * numerator**2 + 4
    root = isqrt(sqr)
    if root**2 == sqr and (numerator + root) % 2 == 0:
        denominator = (numerator + root) // 2
        if gcd(numerator, denominator) == 1:
            count += 1
            print(count, numerator, denominator, numerator * denominator)

    numerator += 1
