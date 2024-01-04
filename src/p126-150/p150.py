SIZE = 1000
grid = [[[0] for _ in range(SIZE)] for _ in range(SIZE)]

t = 0
for d in range(SIZE):
    for i in range(d+1):
        t = (615949*t + 797807) % 2**20
        grid[d - i][i] = [t - 2 ** 19]

print(grid[0][0], grid[1][0], grid[0][1])
# SIZE = 6
# grid = [[15, -7, -5, -26, 5, 3],
#         [-14, -13, 23, -18, 28, 0],
#         [20, 8, -5, 9, 0, 0],
#         [-3, -4, 2, 0, 0, 0],
#         [1, 31, 0, 0, 0, 0],
#         [-16, 0, 0, 0, 0, 0]]
# for row in grid:
#     for (i, col) in enumerate(row):
#         row[i] = [col]

min_sum = 0

# row zero
for col in range(SIZE):
    min_sum = min(min_sum, grid[0][col][0])

# row one
for col in range(SIZE-1):
    min_sum = min(min_sum, grid[1][col][0])
    new_tri = grid[1][col][0] + grid[0][col][0] + grid[0][col + 1][0]
    min_sum = min(min_sum, new_tri)
    grid[1][col].append(new_tri)

for row in range(2, SIZE):
    for col in range(SIZE - row):
        min_sum = min(min_sum, grid[row][col][0])

        # k = 0
        new_tri = grid[row][col][0] + grid[row - 1][col][0] + grid[row - 1][col + 1][0]
        min_sum = min(min_sum, new_tri)
        grid[row][col].append(new_tri)

        for k in range(1, row):
            tri1 = grid[row - 1][col][k]
            tri2 = grid[row - 1][col + 1][k]
            overlap = grid[row - 2][col + 1][k - 1]
            new_tri = grid[row][col][0] + tri1 + tri2 - overlap
            min_sum = min(min_sum, new_tri)
            grid[row][col].append(new_tri)

    # free up space
    grid[row-2] = []

# for row in s:
#     for col in row:
#         print(col[0], end=" ")
#     print()
# print(s[SIZE-1][0])
print(min_sum)
