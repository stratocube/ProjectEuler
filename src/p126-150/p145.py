def reversible_count(num_digits):
    if num_digits % 2 == 0:
        return 20 * 30**(num_digits//2-1)
    
    if num_digits % 4 == 1:
        return 0

    n = (num_digits-3) // 4
    return 5 * 20**(n+1) * 25**n


count_sum = 0
for i in range(2, 10):
    count = reversible_count(i)
    print(count)
    count_sum += count

print(count_sum)
