from math import isqrt
import timeit

def calculate():
    limit = 100_000_000
    m_limit = isqrt(limit // 2)
    k_limit = limit // 10
    discovered = set()

    count = 0
    for m in range(2, m_limit):
        for n in range(1, m):
            for k in range(1, k_limit):
                m_square = m*m
                m_by_n = m*n
                perimeter = 2 * k * (m_square + m_by_n)
                if perimeter >= limit:
                    break

                n_square = n*n
                h = k * (m_square + n_square)
                s1 = k * (m_square - n_square)
                s2 = k * 2*m_by_n

                if h % abs(s1 - s2) == 0:
                    if f'{s1},{s2},{h}' in discovered or \
                        f'{s2},{s1},{h}' in discovered:
                        pass
                    else:
                        discovered.add(f'{s1},{s2},{h}')
                        count += 1

    # print(discovered)
    print(count)


t = timeit.Timer(lambda: calculate())
print(t.timeit(1))
