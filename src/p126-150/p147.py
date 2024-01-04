diagonal_map = {(1, 1): 0}


def diagonal_rects(m, n):
    if (m, n) in diagonal_map:
        return diagonal_map[(m, n)]

    if m == n:
        calc = diagonal_rects(n-1, n) + 4*(n**3-n)//3
        diagonal_map[(n, n)] = calc
        return calc

    calc = diagonal_rects(m, n-1) + (4*m**3-m)//3
    diagonal_map[(m, n)] = calc
    return calc


def cross_hatched_rects(m, n):
    if m > n:
        m, n = n, m

    right_rects = m*(m+1)*n*(n+1)//4
    diag_rects = diagonal_rects(m, n)
    print(m, n, ":")
    print(right_rects, diag_rects)

    return right_rects + diag_rects


total = 0
for i in range(1, 47+1):
    for j in range(1, 43+1):
        sub_rect = cross_hatched_rects(i, j)
        total += sub_rect

print(total)
