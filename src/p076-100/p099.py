from math import log10
line_nums = {}
with open("../../resources/p099_base_exp.txt") as text_file:
    for i, line in enumerate(text_file):
        b, e = map(lambda x: int(x), line.split(','))
        log_val = e * log10(b)
        line_nums[log_val] = i+1

    largest = sorted(line_nums.keys(), reverse=True)[0]
    print(line_nums[largest])
