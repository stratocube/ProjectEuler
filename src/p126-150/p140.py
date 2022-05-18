nugget_sum = 0
fib_prev = 0
fib = 1
for i in range(15):
    temp = fib
    fib = fib_prev + fib
    fib_prev = temp

    a = -fib*fib_prev + 3*fib**2
    nugget_sum += a
    print(2*i+1, a)

    temp = fib
    fib = fib_prev + fib
    fib_prev = temp

    a = fib*fib_prev + 3*fib_prev**2
    nugget_sum += a
    print(2*i+2, a)

print(nugget_sum)
