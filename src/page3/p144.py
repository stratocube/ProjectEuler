from sympy import Matrix


def get_new_point(p, dir):
    x, y = p[0], p[1]
    d = dir[1]**2 + 4*dir[0]**2
    r = dir[1]**2 - 4*dir[0]**2
    s = -2*dir[0]*dir[1]
    return (x*r + y*s) / d, (4*x*s - y*r) / d


def get_new_direction(p, dir):
    n = Matrix([4*p[0], p[1]])
    return 2*n * n.dot(dir)/n.dot(n) - dir


bounces = 0
p0 = Matrix([0, 101/10])
p = Matrix([14/10, -96/10])
dir = p - p0

while p[1] < 0 or p[0] < -0.01 or p[0] > 0.01:
    bounces += 1
    dir = get_new_direction(p, dir)
    p = get_new_point(p, dir)

print(bounces, p, dir)
