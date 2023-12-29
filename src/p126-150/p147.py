tile_map = {(1, 1): 1}


def cross_hatched_rects(m, n):
    if m > n:
        m, n = n, m

    if (m, n) in tile_map:
        return tile_map[(m, n)]

    additional = 0
    additional += n*m*(m+1)//2
    for i in range(1, 2*m, 2):
        additional += min(i, 2*(n-1)) * min(2*m - i, 2*(n-1))
    for i in range(2, 2*m, 2):
        additional += i * (2*m - i)

    total = cross_hatched_rects(m, n-1) + additional
    tile_map[(m, n)] = total
    return total


total = 0
for i in range(1, 43+1):
    for j in range(1, 47+1):
        sub_rect = cross_hatched_rects(i, j)
        total += sub_rect
        #print(sub_rect)

print(tile_map)
print(total)
