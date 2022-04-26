num_discs = 0
x = y = 1
while num_discs <= 1000000000000:
    x, y = 3*x + 2*y, 3*y + 4*x
    blue, num_discs = (x + 1) // 2, (y + 1) // 2
print(blue, num_discs)
