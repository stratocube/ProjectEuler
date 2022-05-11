S_map = {}


def S(n):
    if n in S_map:
        return S_map[n]

    if n <= 4:
        S_map[n] = 2**n
        return S_map[n]

    sol = 1 + S(n-1) + S(n-2) + S(n-3) + S(n-4)
    S_map[n] = sol
    return sol


def T(n):
    return S(n) - S(n-1)


N = 50
print(T(N))
