from math import floor
N = 50

count = 0
for x1 in range(1, N+1):
    for x2 in range(0, N+1):
        for y1 in range(0, N+1):
            start = floor(y1*x2/x1 + 1)
            for y2 in range(start, N+1):
                if y1*(y2-y1) == x1*(x1-x2) or \
                   y2*(y2-y1) == x2*(x1-x2):
                    count += 1

count += N*N
print(count)
