solutions = []

for b in range(1, 100):
    for e in range(2, b):
        num = b**e
        dsum = sum(map(int, str(num)))
        if dsum == b:
            solutions.append(num)
            print(b, e, num)

for i, sol in enumerate(sorted(solutions)):
    print(i+1, sol)
