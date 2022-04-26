import copy


def reduce_grid(puzzle):
    for i, row in enumerate(puzzle):
        for j, entry in enumerate(row):
            if len(entry) == 1:
                # print("found " + str(entry[0]))
                solved_digit = entry[0]
                for r in range(9):
                    if r == i:
                        continue
                    if solved_digit in puzzle[r][j]:
                        puzzle[r][j].remove(solved_digit)
                for c in range(9):
                    if c == j:
                        continue
                    if solved_digit in puzzle[i][c]:
                        puzzle[i][c].remove(solved_digit)
                for r in range(i//3 * 3, (i//3 + 1)*3):
                    for c in range(j//3 * 3, (j//3 + 1)*3):
                        if r == i and c == j:
                            continue
                        if solved_digit in puzzle[r][c]:
                            puzzle[r][c].remove(solved_digit)


def next_unsolved(puzzle):
    for i, row in enumerate(puzzle):
        for j, entry in enumerate(row):
            if len(entry) != 1:
                return i, j
    return None, None


def solve(puzzle):
    i, j = next_unsolved(puzzle)
    if i is None:
        return puzzle

    # print(puzzle)
    choices = list(puzzle[i][j])
    for choice in choices:
        puzzle_copy = copy.deepcopy(puzzle)
        puzzle_copy[i][j] = [choice]
        reduce_grid(puzzle_copy)
        solution = solve(puzzle_copy)
        if solution is not None:
            return solution
    return None


sum_total = 0
with open("../../resources/p096_sudoku.txt") as puzzle_file:
#with open("../../resources/test.txt") as puzzle_file:
    for puzzle_line in puzzle_file:
        print(puzzle_line.rstrip())
        puzzle = []
        for _ in range(9):
            line = puzzle_file.readline().rstrip()
            puzzle.append(list(map(lambda x: [int(x)], list(line))))
        print(puzzle)

        # replace 0's with options
        for i, row in enumerate(puzzle):
            for j, entry in enumerate(row):
                if entry == [0]:
                    puzzle[i][j] = [i for i in range(1, 10)]

        solution = solve(puzzle)
        corner_num = int("".join(map(lambda x: str(x[0]), solution[0][0:3])))
        sum_total += corner_num
        print(str(corner_num))
        for row in solution:
            print(row)

print(sum_total)
