from math import copysign
from numpy import dot
from numpy import subtract


def same_side(E1, E2, P1, P2):
    edge = subtract(E2, E1)
    normal = [-edge[1], edge[0]]
    C = dot(normal, E2)
    C1 = dot(normal, P1)
    C2 = dot(normal, P2)
    if C1 == C or C2 == C:
        return False
    return copysign(1, C - C1) == copysign(1, C - C2)


count = 0
with open("../../resources/p102_triangles.txt") as text_file:
    for triangle in text_file:
        x1, y1, x2, y2, x3, y3 = list(map(lambda x: int(x), triangle.rstrip().split(",")))
        T1, T2, T3 = [x1, y1], [x2, y2], [x3, y3]
        if same_side(T1, T2, [0, 0], T3) and \
            same_side(T1, T3, [0, 0], T2) and \
                same_side(T2, T3, [0, 0], T1):
            print(triangle)
            count += 1

    print(count)
