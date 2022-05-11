def digits(n):
    digit_arr = []
    while n != 0:
        digit_arr.append(n % 10)
        n //= 10
    return digit_arr


solutions = [0]*10000000
solutions[1] = 1
solutions[89] = 89


def get_ans(num):
    if solutions[num] != 0:
        return solutions[num]

    sum_squares = sum(map(lambda x: x*x, digits(num)))
    ans = get_ans(sum_squares)
    solutions[num] = ans
    return ans


count89 = 0
for N in range(1, 10000000):
    if get_ans(N) == 89:
        count89 += 1

print(count89)

