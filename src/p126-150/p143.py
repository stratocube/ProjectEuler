# a^2 = r^2 + rq + q^2
# b^2 = p^2 + pq + q^2
# c^2 = p^2 + pr + r^2
# sol if 1 = x^2 + xy + y^2 has rational solution
# parameterization y = tx - 1 leads to
# x = (2t+1)/(t^2+t+1), y = (t^2-1)/(t^2+t+1)
# sol if t is rational = m/n >= 1
# x = (2mn+n^2)/(m^2+mn+n^2), y = (m^2-n^2)/(m^2+mn+n^2)
# r = 2mn + n^2, q = m^2 - n^2

from math import isqrt, gcd
from collections import defaultdict
import timeit
MAX = 120_000


def do_calc():
    square_pairs = defaultdict(list)
    for m in range(1, isqrt(MAX)):
        for n in range(1, m):
            if gcd(m, n) != 1:
                continue
            if (m-n) % 3 == 0:
                continue

            r = 2*m*n + n**2
            q = m**2 - n**2

            if r+q > MAX:
                break

            if r < q:
                q, r = r, q

            k = 1
            while k*(q+r) <= MAX:
                square_pairs[k*q].append(k*r)
                k += 1

    pqr_sums = set()
    for p in square_pairs:
        p_list = sorted(square_pairs[p])
        if len(p_list) < 2:
            continue
        # print(p, p_list)

        for q_idx in range(len(p_list)):
            for r_idx in range(q_idx+1, len(p_list)):
                q = p_list[q_idx]
                r = p_list[r_idx]
                T = p + q + r
                if T > MAX:
                    break

                # print(q, r)
                if q in square_pairs and r in square_pairs[q]:
                    print(p, q, r, T)
                    pqr_sums.add(T)

    print(sum(pqr_sums))


t = timeit.Timer(lambda: do_calc())
print(t.timeit(1))
