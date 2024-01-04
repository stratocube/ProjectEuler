import numpy as np
from math import inf


def max_subseq(arr):
    max_sub_sum = 0
    current_sum = 0
    idx = 0

    while idx < len(arr):
        if -arr[idx] >= current_sum:
            current_sum = 0
            while arr[idx] <= 0:
                idx += 1
                if idx >= len(arr):
                    return max_sub_sum

        current_sum += arr[idx]
        max_sub_sum = max(max_sub_sum, current_sum)
        idx += 1

    return max_sub_sum


s_arr = np.empty(4000000, int)
for k in range(1, 56):
    s_arr[k-1] = (100003 - 200003*k + 300007*k**3) % 1000000 - 500000

for k in range(56, 4000001):
    s_arr[k-1] = (s_arr[k-25] + s_arr[k-56] + 1000000) % 1000000 - 500000

print(s_arr[9], s_arr[99])
grid = s_arr.reshape(2000, 2000)
print("grid generated")

# grid = np.array([[-2, 5, 3, 2], [9, -6, 5, 7], [3, 2, -1, 3], [-1, 11, -4, -8]])
length = grid.shape[0]
max_sum = 0

# rows
for i in range(length):
    max_sum = max(max_sum, max_subseq(grid[i, :]))

# cols
for j in range(length):
    max_sum = max(max_sum, max_subseq(grid[:, j]))

print("max rows and cols done")

# diagonal
d_arr = np.zeros([length, 2*length-1], int)
for n in range(length):
    np.put(d_arr[n], range(n, n+length), grid[n, :])

for j in range(d_arr.shape[1]):
    max_sum = max(max_sum, max_subseq(d_arr[:, j]))

# anti-diagonal
d_arr = np.zeros([length, 2*length-1], int)
for n in range(length):
    np.put(d_arr[n], range(-n-length, -n), grid[n, :])

for j in range(d_arr.shape[1]):
    max_sum = max(max_sum, max_subseq(d_arr[:, j]))

print(max_sum)
