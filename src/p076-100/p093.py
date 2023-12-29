from fractions import Fraction


def get_solutions2(sub_sol1, sub_sol2):
	discovered = set()
	discovered.add(sub_sol1 + sub_sol2)
	discovered.add(sub_sol1 * sub_sol2)
	discovered.add(sub_sol1 - sub_sol2)
	discovered.add(sub_sol2 - sub_sol1)

	if sub_sol2 != 0:
		if sub_sol1 % sub_sol2 == 0:
			discovered.add(sub_sol1 // sub_sol2)
		else:
			discovered.add(Fraction(sub_sol1, sub_sol2))
	if sub_sol1 != 0:
		if sub_sol2 % sub_sol1 == 0:
			discovered.add(sub_sol2 // sub_sol1)
		else:
			discovered.add(Fraction(sub_sol2, sub_sol1))

	return discovered


def get_solutions3(a, b, c):
	discovered = set()
	for combo in [[(a, b), c], [(a, c), b], [(b, c), a]]:
		sub1 = get_solutions2(*combo[0])
		sub_sol2 = combo[1]
		for sub_sol1 in sub1:
			discovered.add(sub_sol1 + sub_sol2)
			discovered.add(sub_sol1 * sub_sol2)
			discovered.add(sub_sol1 - sub_sol2)
			discovered.add(sub_sol2 - sub_sol1)

			if sub_sol2 != 0:
				if sub_sol1 % sub_sol2 == 0:
					discovered.add(sub_sol1 // sub_sol2)
				else:
					discovered.add(Fraction(sub_sol1, sub_sol2))
			if sub_sol1 != 0:
				if sub_sol2 % sub_sol1 == 0:
					discovered.add(sub_sol2 // sub_sol1)
				else:
					discovered.add(Fraction(sub_sol2, sub_sol1))

	return discovered


def get_solutions4(a, b, c, d):
	discovered = set()
	for combo in [[(a, b, c), d], [(a, b, d), c], [(a, c, d), b], [(b, c, d), a]]:
		sub1 = get_solutions3(*combo[0])
		sub_sol2 = combo[1]
		for sub_sol1 in sub1:
			calc = sub_sol1 + sub_sol2
			if calc.denominator == 1 and calc > 0:
				discovered.add(calc.numerator)

			calc = sub_sol1 * sub_sol2
			if calc.denominator == 1 and calc > 0:
				discovered.add(calc.numerator)

			calc = sub_sol1 - sub_sol2
			if calc.denominator == 1 and calc > 0:
				discovered.add(calc.numerator)

			calc = sub_sol2 - sub_sol1
			if calc.denominator == 1 and calc > 0:
				discovered.add(calc.numerator)

			if sub_sol2 != 0 and sub_sol1 % sub_sol2 == 0:
				calc = sub_sol1 // sub_sol2
				if calc.denominator == 1 and calc > 0:
					discovered.add(calc.numerator)
			if sub_sol1 != 0 and sub_sol2 % sub_sol1 == 0:
				calc = sub_sol2 // sub_sol1
				if calc.denominator == 1 and calc > 0:
					discovered.add(calc.numerator)

	for combo in [[(a, b), (c, d)], [(a, c), (b, d)], [(a, d), (b, c)]]:
		sub1 = get_solutions2(*combo[0])
		sub2 = get_solutions2(*combo[1])
		for sub_sol1 in sub1:
			for sub_sol2 in sub2:
				calc = sub_sol1 + sub_sol2
				if calc.denominator == 1 and calc > 0:
					discovered.add(calc.numerator)

				calc = sub_sol1 * sub_sol2
				if calc.denominator == 1 and calc > 0:
					discovered.add(calc.numerator)

				calc = sub_sol1 - sub_sol2
				if calc.denominator == 1 and calc > 0:
					discovered.add(calc.numerator)

				calc = sub_sol2 - sub_sol1
				if calc.denominator == 1 and calc > 0:
					discovered.add(calc.numerator)

				if sub_sol2 != 0 and sub_sol1 % sub_sol2 == 0:
					calc = sub_sol1 // sub_sol2
					if calc.denominator == 1 and calc > 0:
						discovered.add(calc.numerator)
				if sub_sol1 != 0 and sub_sol2 % sub_sol1 == 0:
					calc = sub_sol2 // sub_sol1
					if calc.denominator == 1 and calc > 0:
						discovered.add(calc.numerator)

	return discovered


M = 0
N = 9
max_seen = 0

for a in range(0, N+1):
	for b in range(a+1, N+1):
		for c in range(b+1, N+1):
			for d in range(c+1, N+1):
				sol = get_solutions4(a, b, c, d)

				for i in range(1, len(sol) + 1):
					if i not in sol:
						if i - 1 > max_seen:
							print(a, b, c, d, i-1)
							max_seen = i - 1
						break

print(max_seen)
