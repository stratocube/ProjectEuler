from sympy import isprime


limit = 2000
count = 1
layer = 1
num = 2

while count < limit:
    up = num + 6 * layer
    next_up = up + 6 * (layer + 1)
    next_layer_first = up + 1
    layer_end = up - 1
    next_layer_end = next_up - 1

    if isprime(next_layer_first - num) and \
        isprime(layer_end - num) and \
            isprime(next_layer_end - num):
        count += 1
        if count == limit:
            break

    next_next_up = next_up + 6*(layer+2)
    if isprime(next_layer_end - num) and \
        isprime(next_layer_end - up) and \
            isprime((next_next_up - 2) - next_layer_end):
        count += 1
        if count == limit:
            num = next_layer_end
            break

    num = up
    layer += 1

print(num)
