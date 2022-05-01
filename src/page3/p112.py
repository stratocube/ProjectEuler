n = 1
bouncy = 0

while True:
    inc = dec = False
    n_left = n
    prev_digit = n_left % 10

    while n_left != 0:
        digit = n_left % 10
        if digit > prev_digit:
            inc = True
        if digit < prev_digit:
            dec = True
        prev_digit = digit
        n_left //= 10

    if inc and dec:
        bouncy += 1

    if bouncy / n >= 0.99:
        break
    n += 1

print(bouncy, n)
