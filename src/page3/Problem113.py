from math import comb


length = 100
total = 2*comb(length+9, 9) - 11

k = length - 1
while k > 1:
    total += comb(k+9, 9) - 10
    k -= 1

print(total)
