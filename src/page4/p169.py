def eval_rep(rep):
    idx = 0
    while rep[idx] == '1':
        idx += 1
        if idx == len(rep):
            return 1

    m = 0
    while rep[idx] == '0':
        idx += 1
        m += 1

    if idx == len(rep)-1:
        return m+1

    return eval_rep(rep[idx+1:]) + m*eval_rep('0' + rep[idx+1:])


N = 10**25
binary_rep = bin(N)[:1:-1]
print(eval_rep(binary_rep))
