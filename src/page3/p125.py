N = 8
palindrome_sum = 0
count = 0
discovered = set()

for begin in range(1, 10**N):
    square_sum = begin**2
    if square_sum >= 10**N:
        break

    for s in range(begin+1, 10**N):
        square_sum += s**2
        if square_sum >= 10**N:
            break

        if str(square_sum) == "".join(reversed(str(square_sum))):
            if square_sum not in discovered:
                palindrome_sum += square_sum
                count += 1
                discovered.add(square_sum)
                print(square_sum)

print(count, len(discovered), palindrome_sum)
