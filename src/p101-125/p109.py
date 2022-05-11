limit = 100
scores = []
doubles = []

for i in range(1, 20+1):
    doubles.append(2*i)
doubles.append(50)

for i in range(1, 20+1):
    scores.append(i)
    scores.append(2*i)
    scores.append(3*i)
scores.append(25)
scores.append(50)

num_checkouts = 0
for d in doubles:
    if d < limit:
        num_checkouts += 1

    for i in range(len(scores)):
        s1 = scores[i]
        if s1 + d < limit:
            num_checkouts += 1

        for j in range(i, len(scores)):
            s2 = scores[j]
            if s2 + s1 + d < limit:
                num_checkouts += 1


print(num_checkouts)
