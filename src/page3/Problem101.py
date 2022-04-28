# Based on the idea that
# for f(1) = y1, f(2) = y2, etc...
# f = y1 * (x-2)(x-3)/[(1-2)(1-3)]
#   + y2 * (x-1)(x-3)/[(2-1)(2-3)]
#   + y3 * (x-1)(x-2)/[(3-1)(3-2)]

def poly2(x):
    return x**3


def poly(x):
    sum = 0
    for exp in range(11):
        sum += (-x)**exp
    return sum

y_arr = [0]
for x in range(1, 10+2):
    y_arr.append(poly(x))

FIT_sum = 0
for k in range(1, 10+1):
    FIT = 0
    for term_idx in range(1, k+1):
        term = y_arr[term_idx]
        for j in range(1, k+1):
            if j == term_idx:
                continue
            term *= (k+1 - j)/(term_idx - j)
        FIT += term
    FIT_sum += FIT

print(FIT_sum)

