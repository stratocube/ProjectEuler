total = 0
for a in range(3, 1001):
    n = (a - 1) // 2
    total += 2*n*a

print(total)
