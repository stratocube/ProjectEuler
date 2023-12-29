from sympy import sieve
from collections import defaultdict
from math import inf

lowest_counts = defaultdict(lambda: inf)

def search_replacements(digits, rep=""):
	if digits == 0:
		if '*' not in rep:
			return 1
		
		count = 0
		low = 0
		lowest_int = inf
		if rep[0] == '*':
			low = 1
		for r in range(low, 10):
			rep_int = int(rep.replace('*', str(r)))
			#print(rep_int)
			if rep_int in sieve:
				lowest_int = min(lowest_int, rep_int)
				count += 1
		
		if lowest_int < lowest_counts[count]:
			lowest_counts[count] = lowest_int
		#print("count="+str(count))
		return count
		
	else:
		count = search_replacements(digits-1, rep+"*")
		
		low = 0
		if rep == "":
			low = 1
		for d in range(low, 10):
			next = search_replacements(digits-1, rep+str(d))
			count = max(count, next)
			
		return count

for i in range(1, 7):
	search_replacements(i)
	print(lowest_counts)