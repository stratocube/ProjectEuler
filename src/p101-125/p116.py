T_map = {}

def T(m, n):
    if n < m:
        return 0
    if n == m:
        return 1

    sum = 0
    i = 0
    while i <= n-m:
        params = (m, n-i-m)
        if params in T_map:
            sub_prob = T_map[params]
        else:
            sub_prob = T(m, n-i-m)
            T_map[params] = sub_prob

        sum += 1 + sub_prob
        i += 1

    return sum


N = 50
print(T(2, N) + T(3, N) + T(4, N))
