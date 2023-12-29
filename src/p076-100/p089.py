numeral = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000, '0': 0}

file = open("../../resources/p089_roman.txt")
total_saved = 0
for line in file:
	line = line.strip()
	print(line)

	roman_value = 0
	next_int = 0
	current_int = next_int = numeral[line[0]]
	for next_char in line[1:]:
		next_int = numeral[next_char]
		if current_int < next_int:
			roman_value -= current_int
		else:
			roman_value += current_int

		current_int = next_int

	roman_value += next_int
	#print(roman_value)

	roman_string = ""
	for subtract_pair in ["MC", "DC", "CX", "LX", "XI", "VI", "I0"]:
		current_int = numeral[subtract_pair[0]]
		subtract_int = numeral[subtract_pair[1]]
		while roman_value >= current_int:
			roman_value -= current_int
			roman_string += subtract_pair[0]

		if roman_value >= current_int - subtract_int:
			roman_value -= current_int - subtract_int
			roman_string += subtract_pair[1] + subtract_pair[0]

	print(roman_string)
	chars_saved = len(line)-len(roman_string)
	if chars_saved < 0:
		break
	print(chars_saved)
	total_saved += chars_saved

print(total_saved)
