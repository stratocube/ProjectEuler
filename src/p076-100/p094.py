P = 1000000000
perimeter_sum = 0
x, y, p1, p2 = 0, 0, 0, 0

while (p1 < P and p2 < P):
	x = 4*y + 4 - x
	y = 4*x - y
	print(x, y)
	
	perimeter_sum += p1 + p2
	# case x+1, x+1, x+2
	p1 = 3*x+4
	# case y, y+1, y+1
	p2 = 3*y+2
	print("P", p1, p1)

print(perimeter_sum)
