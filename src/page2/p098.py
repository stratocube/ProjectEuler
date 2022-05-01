from collections import defaultdict
from itertools import permutations
from math import isqrt

anagram_map = defaultdict(list)
largest_square = 0

# with open("../../resources/test.txt") as word_file:
with open("../../resources/p098_words.txt") as word_file:
    words = word_file.readline().split(",")

# grab the word between quotations
words = list(map(lambda w: w[1:-1], words))

for word in words:
    sorted_word = "".join(sorted(word))
    anagram_map[sorted_word].append(word)

anagrams = list(anagram_map.keys())
for anagram in anagrams:
    # skip if letter combination does not have more than 1 associated word
    if len(anagram_map[anagram]) == 1:
        anagram_map.pop(anagram)
        continue

    print(anagram)
    digit_assign = {}
    unique_chars = list(set(anagram))

    print("  " + " ".join(anagram_map[anagram]))

    # for every possible digit assignment
    for perm in permutations('9876543210', len(unique_chars)):
        for idx, char in enumerate(unique_chars):
            digit_assign[char] = perm[idx]

        for word in anagram_map[anagram]:
            # skip if any word starts with 0
            if digit_assign[word[0]] == '0':
                break

        else:
            # digits are properly assigned
            square_count = 0
            temp_max_square = 0
            for word in anagram_map[anagram]:
                next_num = int("".join(map(lambda x: digit_assign[x], word)))

                if next_num == isqrt(next_num) ** 2:
                    temp_max_square = max(next_num, temp_max_square)
                    square_count += 1

            # set largest square if more than 1 square
            if square_count > 1:
                largest_square = max(temp_max_square, largest_square)

print(largest_square)
