from math import isqrt

P = 1000000000
perimeter_sum = 0


def is_square(i):
    return i == isqrt(i) ** 2


for s in range(2, P//3):
    A1 = (3*s+1)*(s+1)*(s+1)*(s-1)
    A2 = (3*s-1)*(s-1)*(s-1)*(s+1)

    if A1 % 16 == 0 and is_square(A1//16):
        perimeter_sum += 3*s+1
        print(A1//16, s, s, s+1)

    if A2 % 16 == 0 and is_square(A2//16):
        perimeter_sum += 3*s-1
        print(A2//16, s, s, s-1)

print(perimeter_sum)
