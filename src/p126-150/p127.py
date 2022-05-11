from sympy import factorint

N = 120000
count = 0
c_sum = 0

factorizations = {}
for c in range(1, N):
    factorizations[c] = factorint(c)

for c in range(2, N):
    prod = 1
    for c_factor in factorizations[c]:
        prod *= c_factor
        if prod >= c:
            break

    else:
        for a in range(1, c//2):
            prod_with_ab = prod
            for a_factor in factorizations[a]:
                prod_with_ab *= a_factor
                if prod_with_ab >= c:
                    break

            else:
                b = c - a
                for b_factor in factorizations[b]:
                    prod_with_ab *= b_factor
                    if prod_with_ab >= c:
                        break

                else:
                    # Checking GCDs is more time consuming than the product busting
                    # especially for the larger numbers
                    # We already have factorizations so instead of calculating gcd
                    # test these for non-empty set intersection
                    if any(x in factorizations[a].keys()
                           for x in factorizations[b].keys()):
                        continue

                    # These are implied by gcd(a, c) = 1 and a + b = c
                    # if any(x in factorizations[b].keys()
                    #        for x in factorizations[c].keys()):
                    #     continue
                    # if any(x in factorizations[a].keys()
                    #        for x in factorizations[b].keys()):
                    #     continue

                    print(a, b, c)
                    c_sum += c
                    count += 1

print(count)
print(c_sum)
