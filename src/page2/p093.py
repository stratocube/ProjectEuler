
def op(op, a, b):
    if op == '+':
        return a+b
    elif op == '-':
        return a-b
    elif op == '*':
        return a*b
    elif op == '/':
        if b == 0 or a % b != 0:
            raise ValueError
        return a//b



def get_solution(a, b, c, d):
    discovered = set()
    for op1 in "+-*/":
        for op2 in "+-*/":
            for op3 in "+-*/":
                try:
                    discovered.add(op(op3, op(op2, op(op1, a, b), c), d))
                except ValueError:
                    pass
                try:
                    discovered.add(op(op2, op(op1, a, b), op(op3, c, d)))
                except ValueError:
                    pass
                try:
                    discovered.add(op(op1, a, op(op2, b, op(op3, c, d))))
                except ValueError:
                    pass
                try:
                    discovered.add(op(op3, op(op1, a, op(op2, b, c)), d))
                except ValueError:
                    pass
                try:
                    discovered.add(op(op1, a, op(op3, op(op2, b, c), d)))
                except ValueError:
                    pass

    return discovered


N = 23
max_seen = 0

for a in range(0, N+1):
    for b in range(a+1, N+1):
        for c in range(b+1, N+1):
            for d in range(c+1, N+1):
                #print(a, b, c, d)
                sol = get_solution(a, b, c, d)
                sol = sol.union(get_solution(a, b, d, c))
                sol = sol.union(get_solution(a, c, b, d))
                sol = sol.union(get_solution(a, c, d, b))
                sol = sol.union(get_solution(a, d, b, c))
                sol = sol.union(get_solution(a, d, c, b))
                sol = sol.union(get_solution(b, a, c, d))
                sol = sol.union(get_solution(b, a, d, c))
                sol = sol.union(get_solution(c, a, b, d))
                sol = sol.union(get_solution(c, a, d, b))
                sol = sol.union(get_solution(d, a, b, c))
                sol = sol.union(get_solution(d, a, c, b))
                sol = sol.union(get_solution(b, c, a, d))
                sol = sol.union(get_solution(b, d, a, c))
                sol = sol.union(get_solution(c, b, a, d))
                sol = sol.union(get_solution(c, d, a, b))
                sol = sol.union(get_solution(d, b, a, c))
                sol = sol.union(get_solution(d, c, a, b))
                sol = sol.union(get_solution(b, c, d, a))
                sol = sol.union(get_solution(b, d, c, a))
                sol = sol.union(get_solution(c, b, d, a))
                sol = sol.union(get_solution(c, d, b, a))
                sol = sol.union(get_solution(d, b, c, a))
                sol = sol.union(get_solution(d, c, b, a))
                for i in range(1, max(sol)+1):
                    if i not in sol:
                        if i-1 >= max_seen:
                            print(a, b, c, d)
                            max_seen = i-1
                            print(i-1)
                        break

print(max_seen)
